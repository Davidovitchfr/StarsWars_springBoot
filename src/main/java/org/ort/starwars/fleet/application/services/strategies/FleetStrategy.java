package org.ort.starwars.fleet.application.services.strategies;

import java.util.List;

import org.ort.starwars.fleet.dormain.models.Mission;
import org.ort.starwars.fleet.dormain.models.entities.Starship;

public interface FleetStrategy {
    
    boolean match(Mission mission);

    List<Starship> assign(List<Starship> all, Mission mission);
}

