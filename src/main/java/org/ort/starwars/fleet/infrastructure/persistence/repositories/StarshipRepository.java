
package org.ort.starwars.fleet.infrastructure.persistence.repositories;

import org.ort.starwars.fleet.dormain.models.entities.Starship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarshipRepository extends CrudRepository<Starship, Long> {
}
