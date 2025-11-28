package org.ort.starwars.fleet.core.domain.rules.strategies;

import java.util.ArrayList;
import java.util.List;

import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.models.enums.MissionType;
import org.ort.starwars.fleet.core.domain.rules.strategies.helpers.FleetFilter;
import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;

public class FleetStrategyMinEntropy extends AbstractFleetStrategy {

    @Override
    public boolean match(Mission mission) {
        return mission.getType() == MissionType.TRANSPORT
                && mission.isEmergency();
    }

    @Override
    public List<StarshipEntity> assignEntities(List<StarshipEntity> all, Mission mission) {
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
    private List<StarshipEntity> sort(List<StarshipEntity> all, int passagers) {

        // Séparation des petits et gros vaisseaux
        List<StarshipEntity> smallers = new ArrayList<>();
        List<StarshipEntity> biggers = new ArrayList<>();
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
        List<StarshipEntity> ordered = new ArrayList<>();
        ordered.addAll(smallers);
        ordered.addAll(biggers);
        return ordered;
    }
}
