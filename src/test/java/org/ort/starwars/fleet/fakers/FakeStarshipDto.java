package org.ort.starwars.fleet.fakers;

import org.ort.starwars.fleet.infrastructure.adapters.gateways.dtos.SwapiStarshipDto;

public class FakeStarshipDto {

    public static SwapiStarshipDto build(String name, int capacity, int length) {
        return SwapiStarshipDto.builder()
                .name(name)
                .crew("")
                .length(Integer.toString(length))
                .passengers(Integer.toString(capacity))
                .starship_class("")
                .build();
    }
}
