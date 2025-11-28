package org.ort.starwars.fleet.infrastructure.swapi.gateways;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import org.ort.starwars.fleet.core.utils.Parsing;
import org.ort.starwars.fleet.infrastructure.swapi.gateways.dtos.SwapiPageDto;
import org.ort.starwars.fleet.infrastructure.swapi.gateways.dtos.SwapiStarshipDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SwapiProxy {
    private final static String URL = "https://swapi.dev/api";
    private final static String ENDPOINT = "/starships";

    // Injection(s)
    private final WebClient swapi = WebClient.builder()
            .baseUrl(URL)
            .build();

    // Interroge l'API
    // Cette méthode est bloquante
    // => Elle doit être appelée depuis une fonction non réactive
    // => ... ou depuis un @Sheduled
    public List<SwapiStarshipDto> fetch() throws ConnectException {
        var starships = new ArrayList<SwapiStarshipDto>();
        var next = ENDPOINT;
        try {
            while (next != null && next.length() > 0) {

                // Appel de l'API
                SwapiPageDto page = swapi.get()
                        .uri(next)
                        .retrieve()
                        .bodyToMono(SwapiPageDto.class)
                        .block();

                starships.addAll(page.getResults());

                // La page suivante si elle est renseignée, commence par URL
                next = Parsing.getEndpoint(URL, page.getNext());
            }
        } catch (Exception e) {
            throw new ConnectException(e.getMessage());
        }
        return starships;
    }
}
