package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PersonRpository.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
