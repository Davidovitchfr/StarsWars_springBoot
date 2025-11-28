package org.ort.starwars.fleet.core.domain.rules.strategies;

import java.util.List;

import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.models.enums.MissionType;
import org.ort.starwars.fleet.core.domain.rules.strategies.helpers.FleetFilterWithSort;
import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;

public class FleetStrategyMaxSpeed extends AbstractFleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return mission.getType() == MissionType.RESCUE;
    }

    @Override
    public List<StarshipEntity> assignEntities(List<StarshipEntity> all, Mission mission) {
        return FleetFilterWithSort.builder()
                .comparator((a, b) -> Double.compare(b.getSpeed(), a.getSpeed())) // Décroissant
                .passagers(mission.getPassengers())
                .build()
                .apply(all);
    }
}
