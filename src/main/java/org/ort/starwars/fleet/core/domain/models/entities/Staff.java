package org.ort.starwars.fleet.core.domain.models.entities;

import org.ort.starwars.fleet.core.domain.models.enums.Breed;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Staff {


    private final long id;

    // Caractétistiques
    private final Breed breed;

    // Personnel disponible
    private int recruits;
}
