package org.ort.starwars.fleet.infrastructure.adapters.gateways.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SwapiStarshipDto {
    private String name;
    private String crew;
    private String passengers;
    private String starship_class;
    private String[] pilots;
    private String length;
    /* et d'autres champs que nous ne recevons pas */

    public int getCount() {
        return pilots != null ? Math.max(1, pilots.length) : 1;
    }
}
