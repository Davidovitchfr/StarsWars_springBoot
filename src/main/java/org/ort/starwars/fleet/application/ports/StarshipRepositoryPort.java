package org.ort.starwars.fleet.application.ports;

import java.util.List;

import org.ort.starwars.fleet.dormain.models.entities.Starship;

public interface StarshipRepositoryPort {
    List<Starship> findAll();
}
