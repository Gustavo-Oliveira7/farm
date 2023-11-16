package com.betrybe.agrix.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * PersonDto.
 */
public record PersonDto(Long id, String username, Role role) {

  /**
   * PersonDto.
   */
  public static PersonDto toPerson(Person person) {
    return new PersonDto(
      person.getId(),
      person.getUsername(),
      person.getRole()
    );

  }
}
