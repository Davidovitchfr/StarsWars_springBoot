package org.ort.starwars.fleet.core.domain.models.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StarshipType {
    DESTROYER(10),
    DREADNOUGHT(100),
    STATION(1000),
    FIGHTER(1),
    CRAFT(0),
    CARGO(0),
    OTHER(0);

    @Getter
    private final int droids;

    public static StarshipType of(String value) {
        if (value != null) {
            String chunks[] = value.split(" ");
            for (String chunk : chunks) {
                String name = chunk.toUpperCase();
                try {
                    return StarshipType.valueOf(name);
                } catch (IllegalArgumentException ex) {
                }
            }
        }
        return StarshipType.OTHER;
    }
}
