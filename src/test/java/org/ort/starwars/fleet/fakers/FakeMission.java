package org.ort.starwars.fleet.fakers;

import org.ort.starwars.fleet.dormain.models.Mission;
import org.ort.starwars.fleet.dormain.models.enums.MissionType;

public class FakeMission {

    public static Mission of(MissionType type, int passengers) {
        return of(type, passengers, false);
    }

    public static Mission of(MissionType type, int passengers, boolean emergency) {
        return Mission.builder()
                .type(type)
                .emergency(emergency)
                .passengers(passengers)
                .build();
    }
}
