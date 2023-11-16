package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonController.
 */

@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * createPerson.
   */
  @PostMapping
  public ResponseEntity<PersonDto> createPerson(@RequestBody Person person) {
    Person created = personService.create(person);
    PersonDto personDto = new PersonDto(created.getId(),
        created.getUsername(),
        created.getRole());
    return ResponseEntity.status(201).body(personDto);
  }

}