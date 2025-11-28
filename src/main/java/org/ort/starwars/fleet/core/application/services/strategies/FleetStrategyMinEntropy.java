
package org.ort.starwars.fleet.core.application.services.strategies;

import java.util.ArrayList;
import java.util.List;

import org.ort.starwars.fleet.core.application.services.strategies.helpers.FleetFilter;
import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.models.entities.Starship;
import org.ort.starwars.fleet.core.domain.models.enums.MissionType;

public class FleetStrategyMinEntropy implements FleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return mission.getType() == MissionType.TRANSPORT
                && mission.isEmergency();
    }

    @Override
    public List<Starship> assign(List<Starship> all, Mission mission) {
        int limit = mission.getPassengers();
        var order = sort(all, limit);
        return FleetFilter.builder()
                .passagers(limit)
                .build()
                .apply(order);
    }

    /**
     * On commencera à chercher dans les petits vaisseaux par capacité décroissante
     * ... puis dans les gros vaissaux par capacité croissante
     */
    private List<Starship> sort(List<Starship> all, int passagers) {

        // Séparation des petits et gros vaisseaux
        List<Starship> smallers = new ArrayList<>();
        List<Starship> biggers = new ArrayList<>();
        for (var starship : all) {
            if (starship.getPassengers() <= passagers) {
                smallers.add(starship);
            } else {
                biggers.add(starship);
            }
        }

        // Tri
        smallers.sort((a, b) -> Integer.compare(b.getPassengers(), a.getPassengers())); // Décroissant
        biggers.sort((a, b) -> Integer.compare(a.getPassengers(), b.getPassengers())); // Croissant

        // Concaténation
        List<Starship> ordered = new ArrayList<>();
        ordered.addAll(smallers);
        ordered.addAll(biggers);
        return ordered;
    }
}
