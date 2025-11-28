package org.ort.starwars.fleet.core.domain.rules.strategies;

import org.ort.starwars.fleet.core.domain.models.Mission;

public class FleetStrategyDefaut extends FleetStrategyMinEntropy {
    @Override
    public boolean match(Mission mission) {
        return true;
    }
}
