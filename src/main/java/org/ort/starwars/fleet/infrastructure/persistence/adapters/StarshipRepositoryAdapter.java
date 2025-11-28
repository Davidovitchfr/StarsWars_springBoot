package org.ort.starwars.fleet.infrastructure.persistence.adapters;

import java.util.stream.StreamSupport;

import org.ort.starwars.fleet.core.application.ports.in.StarshipRepositoryPort;
import org.ort.starwars.fleet.core.domain.models.entities.Starship;
import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;
import org.ort.starwars.fleet.infrastructure.persistence.mappers.StarshipMapper;
import org.ort.starwars.fleet.infrastructure.persistence.repositories.StarshipRepository;
import org.springframework.stereotype.Component;

@Component
public class StarshipRepositoryAdapter implements StarshipRepositoryPort {

    private final StarshipRepository repository;
    private final StarshipMapper mapper;

    public StarshipRepositoryAdapter(
            StarshipRepository repository,
            StarshipMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Iterable<Starship> findAll() {
        Iterable<StarshipEntity> entities = repository.findAll();
        return mapper.toDomain(entities);
    }

        @Override
    public void saveAll(Iterable<Starship> starships) {
        repository.saveAll(
            StreamSupport.stream(starships.spliterator(), false)
                         .map(mapper::toEntity)
                         .toList()
        );
    }

    @Override
    public void deleteAll(Iterable<Starship> starships) {
        repository.deleteAll(
            StreamSupport.stream(starships.spliterator(), false)
                         .map(mapper::toEntity)
                         .toList()
        );
    }
}
