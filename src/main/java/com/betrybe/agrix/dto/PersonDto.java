package com.betrybe.agrix.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * PersonDto.
 */
public record PersonDto(Long id, String username, Role role) {
  public Person toPerson() {
    return new Person(username, null, role);
  }
}
