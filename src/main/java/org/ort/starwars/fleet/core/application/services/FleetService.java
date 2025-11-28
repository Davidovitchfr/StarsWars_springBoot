package org.ort.starwars.fleet.core.application.services;

import java.util.Collections;
import java.util.List;

import org.ort.starwars.fleet.core.application.ports.in.StarshipRepositoryPort;
import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.models.entities.Starship;
import org.ort.starwars.fleet.core.utils.Iterables;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FleetService {
    /*
     * private FleetStrategy[] STRATEGIES = {
     * new FleetStrategyMinEntropy(),
     * new FleetStrategyMinCost(),
     * new FleetStrategyMaxSpeed(),
     * new FleetStrategyDefaut(),
     * };
     */

    private final StarshipRepositoryPort repository;

    
    /**
     * Réserve une flotte de vaisseaux avec une stratégie adaptée à la mission
     */
    public List<Starship> forMission(Mission mission) {
        List<Starship> starships = Iterables.toList(repository.findAll());
        /*
         * for (FleetStrategy strategy : STRATEGIES) {
         * if (strategy.match(mission)) {
         * return strategy.assign(starships, mission);
         * }
         * }
         */

        // Aucune stratégie ne s'applique !
        return Collections.emptyList();
    }
}
