package org.ort.starwars.fleet.core.domain.rules.strategies.helpers;

import java.util.ArrayList;
import java.util.List;

import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class FleetFilter {
    private final int passagers;

    public List<StarshipEntity> apply(List<StarshipEntity> range) {
        List<StarshipEntity> selected = new ArrayList<>();

        // On décompte les passagers embarqués jusqu'à 0
        int remaining = passagers;
        for (StarshipEntity starship : range) {
            if (remaining <= 0) {
                break;
            }

            int capacity = starship.getPassengers();
            if (capacity > 0) {
                remaining -= Math.min(remaining, capacity);
                selected.add(starship);
            }
        }
        return selected;
    }
}
