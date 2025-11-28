package org.ort.starwars.fleet.infrastructure.persistence.mappers;

import java.util.List;

import org.ort.starwars.fleet.core.domain.models.entities.Starship;
import org.ort.starwars.fleet.core.utils.Iterables;
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

        public List<Starship> toDomain(Iterable<StarshipEntity> entities) {
            return Iterables.toList(entities)
                    .stream()
                    .map(starship->toDomain(starship))
                    .toList();
        }

}
