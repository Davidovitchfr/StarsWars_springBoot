package org.ort.starwars.fleet.core.domain.rules.strategies.helpers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class FleetFilterWithSort extends FleetFilter {
    private final Comparator<StarshipEntity> comparator;

    public List<StarshipEntity> apply(List<StarshipEntity> range) {
        List<StarshipEntity> sorted = new ArrayList<>();
        sorted.addAll(range);
        sorted.sort(comparator);
        return super.apply(sorted);
    }
}
