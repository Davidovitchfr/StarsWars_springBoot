
package org.ort.starwars.fleet.core.application.services.strategies;

import java.util.List;

import org.ort.starwars.fleet.core.application.services.strategies.helpers.FleetFilterWithSort;
import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.models.entities.Starship;
import org.ort.starwars.fleet.core.domain.models.enums.MissionType;

public class FleetStrategyMinCost implements FleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return mission.getType() == MissionType.TRANSPORT
                && !mission.isEmergency();
    }

    @Override
    public List<Starship> assign(List<Starship> all, Mission mission) {
        return FleetFilterWithSort.builder()
                .comparator((a, b) -> Double.compare(a.getCost(), b.getCost())) // Croissant
                .passagers(mission.getPassengers())
                .build()
                .apply(all);
    }
}
