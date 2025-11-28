package org.ort.starwars.fleet.core.domain.rules;

import org.ort.starwars.fleet.core.domain.exception.NoStrategyException;
import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.rules.strategies.FleetStrategy;
import org.ort.starwars.fleet.core.domain.rules.strategies.FleetStrategyDefaut;
import org.ort.starwars.fleet.core.domain.rules.strategies.FleetStrategyMaxSpeed;
import org.ort.starwars.fleet.core.domain.rules.strategies.FleetStrategyMinCost;
import org.ort.starwars.fleet.core.domain.rules.strategies.FleetStrategyMinEntropy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SelectStrategyRule {
    private FleetStrategy[] STRATEGIES = {
        new FleetStrategyMinEntropy(),
        new FleetStrategyMinCost(),
        new FleetStrategyMaxSpeed(),
        new FleetStrategyDefaut(),
    };

    @Getter
    private final static SelectStrategyRule instance = new SelectStrategyRule();

    public AssignFleetRule forMission(Mission mission) throws NoStrategyException {
        for (FleetStrategy strategy : STRATEGIES) {
            if (strategy.match(mission)) {
                return strategy;
            }
        }
        throw new NoStrategyException("Aucune stratégie ne s'applique pour la mission " + mission);
    }
}
