package org.ort.starwars.fleet.core.domain.models.entities;

import org.apache.logging.log4j.util.Strings;
import org.ort.starwars.fleet.core.domain.models.enums.StarshipType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Starship {

    private Long id;
    private String name;
    private StarshipType category;
    private int length;
    private int crew;
    private int passengers;
    private String pilot;

    public String getKey() {
        return Strings.isBlank(pilot) ? name : name + " " + pilot;
    }

    public double getSpeed() {
        double l = this.length;
        return l > 0 ? 10000.0 / l : 0;
    }

    public double getCost() {
        double l = this.length;
        return l * l;
    }
}