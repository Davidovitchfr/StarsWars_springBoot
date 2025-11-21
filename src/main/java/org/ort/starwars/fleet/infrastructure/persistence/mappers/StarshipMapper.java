package org.ort.starwars.fleet.infrastructure.persistence.mappers;

import org.ort.starwars.fleet.dormain.models.entities.Starship;
import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;
import org.springframework.stereotype.Component;

@Component
public class StarshipMapper {

    public StarshipEntity toEntity(Starship domain) {
        if (domain == null) return null;

        return StarshipEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .category(domain.getCategory())
                .length(domain.getLength())
                .crew(domain.getCrew())
                .passengers(domain.getPassengers())
                .pilot(domain.getPilot())
                .build();
    }

    public Starship toDomain(StarshipEntity entity) {
        if (entity == null) return null;

        return Starship.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .length(entity.getLength())
                .crew(entity.getCrew())
                .passengers(entity.getPassengers())
                .pilot(entity.getPilot())
                .build();
    }
}
