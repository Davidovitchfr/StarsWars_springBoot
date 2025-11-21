package org.ort.starwars.fleet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ort.starwars.fleet.dormain.models.Mission;
import org.ort.starwars.fleet.dormain.models.entities.Starship;
import org.ort.starwars.fleet.dormain.models.enums.MissionType;
import org.ort.starwars.fleet.fakers.FakeMission;
import org.ort.starwars.fleet.fakers.FakeStarship;

@ExtendWith(MockitoExtension.class)
class AssignFleetForRescueTest extends AssignFleetForAny {

	@Test
	public void rescueTeam1() {

		// Given
		Mission mission = FakeMission.of(MissionType.RESCUE, 15);
		Starship A = FakeStarship.of("A", 40, L);
		Starship B = FakeStarship.of("B", 10, XS);
		Starship C = FakeStarship.of("C", 5, M);
		Starship D = FakeStarship.of("D", 20, M);
		Starship E = FakeStarship.of("E", 15, S);

		// When
		when(starshipRepository.findAll()).thenReturn(List.of(A, B, C, D, E));

		// Then
		assertThat(fleetService.forMission(mission))
				.containsExactly(B, E);
	}
}
