package org.ort.starwars.fleet.application.services.strategies;

import java.util.List;

import org.ort.starwars.fleet.application.services.strategies.helpers.FleetFilterWithSort;
import org.ort.starwars.fleet.dormain.models.Mission;
import org.ort.starwars.fleet.dormain.models.entities.Starship;
import org.ort.starwars.fleet.dormain.models.enums.MissionType;

public class FleetStrategyMaxSpeed implements FleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return mission.getType() == MissionType.RESCUE;
    }

    @Override
    public List<Starship> assign(List<Starship> all, Mission mission) {
        return FleetFilterWithSort.builder()
                .comparator((a, b) -> Double.compare(b.getSpeed(), a.getSpeed())) // Décroissant
                .passagers(mission.getPassengers())
                .build()
                .apply(all);
    }
}
