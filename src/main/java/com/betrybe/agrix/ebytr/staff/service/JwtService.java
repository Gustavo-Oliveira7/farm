package com.betrybe.agrix.ebytr.staff.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import java.security.AlgorithmConstraints;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * JWTService.
 */
@Service
public class JwtService {

  @Value("Arievilo")
  private String secret;

  /**
   * GenerateToken.
   */
  public String generateToken(Person person) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.create()
      .withIssuer("agrix")
      .withSubject(person.getUsername())
      .withExpiresAt(expirationDate())
      .sign(algorithm);
  }

  /**
   * tokenValidation.
   */
  public String tokenValidation(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.require(algorithm)
      .withIssuer("agrix")
      .build()
      .verify(token)
      .getSubject();
  }


  private Instant expirationDate() {
    return LocalDateTime.now()
      .plusHours(2)
      .toInstant(ZoneOffset.of("-03:00"));
  }
}
