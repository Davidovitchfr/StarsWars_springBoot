package org.ort.starwars.fleet.infrastructure.adapters.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.ort.starwars.fleet.application.services.FleetService;
import org.ort.starwars.fleet.dormain.models.Mission;
import org.ort.starwars.fleet.dormain.models.entities.Starship;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
public class ApiEndpointFleetController {

    private final FleetService fleetService;

    @PostMapping("/fleet")
    public List<Starship> post(@RequestBody Mission mission) {
        return fleetService.forMission(mission);
    }
}
