package org.ort.starwars.fleet;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.ort.starwars.fleet.application.services.FleetService;
import org.ort.starwars.fleet.infrastructure.persistence.repositories.StarshipRepository;

public class AssignFleetForAny {
    public static final int XXS = 1;
    public static final int XS = 2;
    public static final int S = 3;
    public static final int M = 5;
    public static final int L = 8;
    public static final int XL = 13;
    public static final int XXL = 21;

    // Domaine = testée
    protected FleetService fleetService;

    // Infra = simulé
    @Mock
    protected StarshipRepository starshipRepository;

    @BeforeEach
    void setup() {
        fleetService = new FleetService(starshipRepository);
    }
}
