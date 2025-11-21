
package org.ort.starwars.fleet.infrastructure.persistence.repositories;

import org.ort.starwars.fleet.dormain.models.entities.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {
}
