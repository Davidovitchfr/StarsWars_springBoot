package org.ort.starwars.fleet.fakers;

import org.ort.starwars.fleet.dormain.models.entities.Starship;

public class FakeStarship {

    public static Starship of(String name, int capacity, int length) {
        return Starship.builder()
                .pilot("*")
                .name(name)
                .length(length)
                .passengers(capacity)
                .build();
    }
}
