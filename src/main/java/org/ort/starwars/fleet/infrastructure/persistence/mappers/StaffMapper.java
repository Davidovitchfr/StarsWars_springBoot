package org.ort.starwars.fleet.infrastructure.persistence.mappers;

import org.ort.starwars.fleet.dormain.models.entities.*;
import org.ort.starwars.fleet.infrastructure.persistence.entities.StaffEntity;
import org.springframework.stereotype.Component;

@Component
public class StaffMapper {

    public StaffEntity toEntity(Staff domain) {
        if (domain == null) return null;

        return StaffEntity.builder()
                .id(domain.getId())
                .breed(domain.getBreed())
                .recruits(domain.getRecruits())
                .build();
    }

    public Staff toDomain(StaffEntity entity) {
        if (entity == null) return null;

        return Staff.builder()
                .id(entity.getId())
                .breed(entity.getBreed())
                .recruits(entity.getRecruits())
                .build();
    }
}
