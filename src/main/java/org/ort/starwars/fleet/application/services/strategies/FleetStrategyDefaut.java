package org.ort.starwars.fleet.application.services.strategies;

import org.ort.starwars.fleet.dormain.models.Mission;

public class FleetStrategyDefaut extends FleetStrategyMinEntropy {
    @Override
    public boolean match(Mission mission) {
        return true;
    }
}

