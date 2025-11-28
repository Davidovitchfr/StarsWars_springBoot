package org.ort.starwars.fleet.core.domain.rules.strategies;

import java.util.List;
import java.util.stream.Collectors;

import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.models.entities.Starship;
import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;

public abstract class AbstractFleetStrategy implements FleetStrategy {
    
    @Override
    public final List<Starship> assign(List<Starship> all, Mission mission) {
        List<StarshipEntity> entities = all.stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
   
        List<StarshipEntity> result = assignEntities(entities, mission);

        return result.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }
    
    protected StarshipEntity toEntity(Starship starship) {
        StarshipEntity entity = new StarshipEntity();
        entity.setId(starship.getId());
        entity.setName(starship.getName());
        entity.setCategory(starship.getCategory());
        entity.setLength(starship.getLength());
        entity.setCrew(starship.getCrew());
        entity.setPassengers(starship.getPassengers());
        entity.setPilot(starship.getPilot());
        return entity;
    }
    
    protected Starship toDomain(StarshipEntity entity) {
        Starship starship = new Starship();
        starship.setId(entity.getId());
        starship.setName(entity.getName());
        starship.setCategory(entity.getCategory());
        starship.setLength(entity.getLength());
        starship.setCrew(entity.getCrew());
        starship.setPassengers(entity.getPassengers());
        starship.setPilot(entity.getPilot());
        return starship;
    }
}