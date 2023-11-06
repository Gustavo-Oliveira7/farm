package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import com.betrybe.agrix.services.CropService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CropController.
 */

@RestController
@RequestMapping("/crops")
public class CropController {
  @Autowired
  private CropService cropService;
  @Autowired
  private CropRepository cropRepository;
  @Autowired
  private FertilizerRepository fertilizerRepository;

  @GetMapping
  public ResponseEntity<List<CropDto>> getCrops() {
    List<CropDto> cropDtos = cropService.getCrops();
    return ResponseEntity.status(200).body(cropDtos);
  }

  /**
   * getcropbyid.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Object> getCropById(
      @PathVariable("id") Integer id) {
    try {
      Crop crop = cropService.getCropById(id);
      CropDto cropDto = new CropDto(
          crop.getId(),
          crop.getName(),
          crop.getPlantedArea(),
          crop.getPlantedDate(),
          crop.getHarvestDate(),
          crop.getFarm().getId());
      return ResponseEntity.status(200).body(cropDto);
    } catch (RuntimeException error) {
      return ResponseEntity.status(404).body("Plantação não encontrada!");
    }
  }

  /**
   * getFertilizersByCropId.
   */
  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<?> getFertilizersByCropId(@PathVariable Integer cropId) {
    Optional<Crop> crop = cropRepository.findById(cropId);
    if (crop.isPresent()) {
      Crop cropb = crop.get();
      return ResponseEntity.status(200).body(cropb.getFertilizers());
    } else {
      return ResponseEntity.status(404).body("Plantação não encontrada!");
    }
  }

  /**
   * e.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> cropWithFertilizer(
      @PathVariable Integer cropId,
      @PathVariable Integer fertilizerId
  ) {
    Optional<Crop> cropOp = cropRepository.findById(cropId);
    Optional<Fertilizer> fertilizerOp = fertilizerRepository.findById(fertilizerId);

    if (cropOp.isPresent() && fertilizerOp.isPresent()) {
      Crop crop = cropOp.get();
      Fertilizer fertilizer = fertilizerOp.get();
      crop.getFertilizers().add(fertilizer);
      cropRepository.save(crop);
      return ResponseEntity.status(201).body("Fertilizante e plantação associados com sucesso!");
    } else if (cropOp.isEmpty()) {
      return ResponseEntity.status(404).body("Plantação não encontrada!");
    } else {
      return ResponseEntity.status(404).body("Fertilizante não encontrado!");
    }
  }
}
