package com.betrybe.agrix.controllers;


import com.betrybe.agrix.dto.AuthDto;
import com.betrybe.agrix.dto.TokenDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.JwtService;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController.
 */

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final AuthenticationManager authenticationManager;
  private final PersonService personService;
  private final JwtService jwtService;


  /**
   * Constructor.
   */
  @Autowired
  public AuthController(AuthenticationManager authenticationManager, PersonService personService,
      JwtService jwtService) {
    this.authenticationManager = authenticationManager;
    this.personService = personService;
    this.jwtService = jwtService;
  }

  /**
   * Login.
   */
  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(
      @RequestBody AuthDto authDto) {

    UsernamePasswordAuthenticationToken usernamePassword =
        new UsernamePasswordAuthenticationToken(authDto.username(),
        authDto.password());
    Authentication auth = authenticationManager.authenticate(usernamePassword);
    Person person = (Person) auth.getPrincipal();

    String token = jwtService.generateToken(person);
    TokenDto response = new TokenDto(token);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}

