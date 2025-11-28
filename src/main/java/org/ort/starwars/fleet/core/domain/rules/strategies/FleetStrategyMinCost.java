package org.ort.starwars.fleet.core.domain.rules.strategies;

import java.util.List;

import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.models.enums.MissionType;
import org.ort.starwars.fleet.core.domain.rules.strategies.helpers.FleetFilterWithSort;
import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;

public class FleetStrategyMinCost extends AbstractFleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return mission.getType() == MissionType.TRANSPORT
                && !mission.isEmergency();
    }

    @Override
    public List<StarshipEntity> assignEntities(List<StarshipEntity> all, Mission mission) {
        return FleetFilterWithSort.builder()
                .comparator((a, b) -> Double.compare(a.getCost(), b.getCost())) // Croissant
                .passagers(mission.getPassengers())
                .build()
                .apply(all);
    }
}
