package org.ort.starwars.fleet.core.domain.rules.strategies;

import java.util.List;

import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.rules.AssignFleetRule;
import org.ort.starwars.fleet.infrastructure.persistence.entities.StarshipEntity;

public interface FleetStrategy extends AssignFleetRule{
    boolean match(Mission mission);

    List<StarshipEntity> assignEntities(List<StarshipEntity> all, Mission mission);
}

