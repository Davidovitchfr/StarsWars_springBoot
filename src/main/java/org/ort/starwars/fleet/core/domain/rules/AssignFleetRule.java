package org.ort.starwars.fleet.core.domain.rules;

import java.util.List;

import org.ort.starwars.fleet.core.domain.models.Mission;
import org.ort.starwars.fleet.core.domain.models.entities.Starship;

public interface AssignFleetRule {

    List<Starship> assign(List<Starship> all, Mission mission);
}