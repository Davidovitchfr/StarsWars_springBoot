package org.ort.starwars.fleet.infrastructure.jobs;

import java.net.ConnectException;
import java.util.stream.Stream;

import org.ort.starwars.fleet.infrastructure.swapi.gateways.SwapiProxy;
import org.ort.starwars.fleet.infrastructure.swapi.gateways.mappers.SwapiStarshipMapper;
import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;
import org.ort.starwars.fleet.infrastructure.persistence.repositories.StarshipRepository;
import org.ort.starwars.fleet.core.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class Etl implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Etl.class);

    private final StarshipRepository repository;
    private final SwapiStarshipMapper mapper;
    private final SwapiProxy swapi;

    @PostConstruct
    @Scheduled(fixedRate = 3600000)
    @Transactional()
    public void run() {
        LOGGER.info("Import périodique en cours...");
        try {

            // Extract & Transform
            var after = swapi.fetch()
                    .stream()
                    .flatMap(dto -> Stream.of(mapper.toDomain(dto)))
                    .toList();
            

            // Load
            var before = repository.findAll();
            var merge = new Merge<String, StarshipEntity>(before, starship -> {
                return starship.getPilot() == null || starship.getPilot().isBlank() ? starship.getName() : starship.getName() + " " + starship.getPilot();
            });

            var afterEntities = after.stream()
                .map(starship -> {
                    StarshipEntity entity = new StarshipEntity();
                    entity.setId(starship.getId());
                    entity.setName(starship.getName());
                    entity.setPilot(starship.getPilot());
                    entity.setCategory(starship.getCategory());
                    entity.setLength(starship.getLength());
                    entity.setCrew(starship.getCrew());
                    entity.setPassengers(starship.getPassengers());
                    return entity;
                })
                .toList();

            merge.addAll(afterEntities, (afterEntity, beforeEntity) -> afterEntity.setId(beforeEntity.getId()));
            // repository.saveAll(merge.getSaved());
            // repository.deleteAll(merge.getDeleted());

            // Conclusion
            LOGGER.info("Import périodique exécutée !");
        } catch (ConnectException e) {
            LOGGER.warn("Import périodique en échec : SWAPI ne répond pas");
        }
    }
}
