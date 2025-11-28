package org.ort.starwars.fleet.infrastructure.swapi.gateways.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SwapiPageDto {
    private int count;
    private String next;
    private String previous;
    private final List<SwapiStarshipDto> results = new ArrayList<>();
}
