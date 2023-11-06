package com.betrybe.agrix.dto;


import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;

/**
 * CropDto.
 */
public record CropDto(
    Integer id,
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate,
    Integer farmId)  {

  public static CropDto fromCrop(Crop crop)  {
    return new CropDto(crop.getId(), crop.getName(),
      crop.getPlantedArea(), crop.getPlantedDate(), crop.getHarvestDate(), crop.getFarm().getId());
  }
}
