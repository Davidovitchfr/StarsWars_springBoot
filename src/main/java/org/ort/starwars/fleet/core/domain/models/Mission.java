package org.ort.starwars.fleet.core.domain.models;

import org.ort.starwars.fleet.core.domain.models.enums.MissionType;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Mission {
    private MissionType type;
    private int passengers;
    private boolean emergency;
}
