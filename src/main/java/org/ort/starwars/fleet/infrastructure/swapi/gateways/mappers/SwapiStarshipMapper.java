package org.ort.starwars.fleet.infrastructure.swapi.gateways.mappers;

import java.util.ArrayList;
import java.util.List;

import org.ort.starwars.fleet.core.domain.models.entities.Starship;
import org.ort.starwars.fleet.core.domain.models.enums.StarshipType;
import org.ort.starwars.fleet.infrastructure.swapi.gateways.dtos.SwapiStarshipDto;
import org.ort.starwars.fleet.core.utils.Iterables;
import org.ort.starwars.fleet.core.utils.Parsing;
import org.springframework.stereotype.Component;

@Component
public class SwapiStarshipMapper {

    public Starship[] toDomain(SwapiStarshipDto dto) {
        return toDomain(dto, null);
    }

    public Starship[] toDomain(SwapiStarshipDto dto, Long id) {
        String[] pilots = dto.getPilots();
        if (pilots == null || pilots.length < 1) {
            pilots = new String[] { "" };
        }

        // On crée un vaisseau par pilote
        List<Starship> starships = new ArrayList<>();
        boolean suffix = pilots.length >= 2;
        int num = 0;
        for (String pilot : pilots) {
            num += 1;
            starships.add(Starship.builder()
                    // .id(id)
                    .name(suffix ? dto.getName() + " " + num : dto.getName())
                    .pilot(pilot)
                    .crew(parseRange(dto.getCrew()))
                    .passengers(parseRange(dto.getPassengers()))
                    .category(StarshipType.of(dto.getStarship_class()))
                    .length(Parsing.getInt(dto.getLength(), -1))
                    .build());
        }

        return Iterables.toArray(starships, Starship.class);
    }

    // Routimes de parsing

    private int parseRange(String value) {
        int[] range = Parsing.getRange(value);
        return range.length > 0 ? range[0] : 0;
    }
}
