package com.betrybe.agrix.dto;

import com.betrybe.agrix.models.entities.Farm;

/**
 * FarmDTO.
 */

public record FarmDto(Integer id, String name, Double size) {
  public Farm toFarm() {
    return new Farm(id, name, size, null);
  }

}
