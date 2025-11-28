package org.ort.starwars.fleet.infrastructure.swapi.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.ort.starwars.fleet.configuration.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApiRootController {

    @Autowired
    private Settings settings;

    @GetMapping("/api")
    public String get() {
        return settings.getVersion() + " " + settings.getAbout();
    }
}
