package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonController.
 */

@RestController
@RequestMapping("persons")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Create a person.
   */
  public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto) {
    Person person = personDto.toPerson();
    Person created = personService.create(person);

    PersonDto createdDto = new PersonDto(
        created.getId(),
        created.getUsername(),
        created.getRole()
    );
    return ResponseEntity.status(201).body(createdDto);
  }
}
