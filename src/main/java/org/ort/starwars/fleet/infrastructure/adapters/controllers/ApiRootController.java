package org.ort.starwars.fleet.infrastructure.adapters.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.ort.starwars.fleet.infrastructure.configuration.*;
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
