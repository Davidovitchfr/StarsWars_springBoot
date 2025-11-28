package org.ort.starwars.fleet.core.application.ports.in;

import org.ort.starwars.fleet.core.domain.models.entities.Starship;

public interface StarshipRepositoryPort {
    Iterable<Starship> findAll();
    void saveAll(Iterable<Starship> starships);
    void deleteAll(Iterable<Starship> starships);
}
