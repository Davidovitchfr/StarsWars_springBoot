package org.ort.starwars.fleet.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class Settings {
    private String version;
    private String author;
    private String about;
}
