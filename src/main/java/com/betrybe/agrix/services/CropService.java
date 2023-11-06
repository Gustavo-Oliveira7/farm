package com.betrybe.agrix.services;


import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CropService.
 */

@Service
public class CropService {
  @Autowired
  private CropRepository cropRepository;

  @Autowired
  private FarmRepository farmRepository;

  @Autowired
  private FarmService farmService;


  /**
   * CreateCrop.
   */
  public CropDto createCrop(Integer farmId, CropDto cropDto) {
    Optional<Farm> farm = farmRepository.findById(farmId);

    if (farm.isPresent()) {
      Crop crop = new Crop();
      Farm hasFarm = farm.get();
      crop.setName(cropDto.name());
      crop.setPlantedArea(cropDto.plantedArea());
      crop.setHarvestDate(cropDto.harvestDate());
      crop.setPlantedDate(cropDto.plantedDate());
      crop.setFarm(hasFarm);
      Crop create = cropRepository.save(crop);
      return CropDto.fromCrop(create);
    } else {
      throw new RuntimeException();

    }
  }

  /**
   * getcrops by farmid.
   */
  public List<CropDto> cropsByFarm(Integer farmId) {
    Optional<Farm> farm = farmRepository.findById(farmId);

    if (farm.isPresent()) {
      List<Crop> crops = cropRepository.findByFarmId(farmId);
      System.out.println(crops);
      return crops.stream()
        .map(crop -> new CropDto(crop.getId(),
          crop.getName(),
          crop.getPlantedArea(),
          crop.getPlantedDate(),
          crop.getHarvestDate(),
          farmId))
        .collect(Collectors.toList());
    } else {
      throw new RuntimeException();
    }
  }

  /**
   * GetCrops.
   */

  public List<CropDto> getCrops() {
    List<Crop> crops = cropRepository.findAll();
    return crops.stream()
      .map(crop -> new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getPlantedDate(),
        crop.getHarvestDate(),
        crop.getFarm().getId()))
      .collect(Collectors.toList());
  }

  /**
   * GetCropsByID.
   */
  public Crop getCropById(Integer id) {
    Optional<Crop> crop = cropRepository.findById(id);

    if (crop.isEmpty()) {
      throw new RuntimeException();
    }
    return crop.get();
  }

}
