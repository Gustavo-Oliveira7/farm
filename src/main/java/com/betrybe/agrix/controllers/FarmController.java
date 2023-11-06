package com.betrybe.agrix.controllers;


import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FarmController.
 */

@RestController
@RequestMapping("/farms")
public class FarmController {
  @Autowired
  private final FarmService farmService;
  @Autowired
  private final CropService cropService;

  @Autowired
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }


  /**
   * CreateFarm.
   */
  @PostMapping
  public ResponseEntity<Farm> create(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.create(farmDto.toFarm());
    return ResponseEntity.status(201).body(newFarm);
  }


  /**
   * Get all farms.
   */
  @GetMapping
  public List<Farm> getFarms() {
    List<Farm> farm = farmService.findAll();
    return farm;
  }


  /**
   * Get farms by ID.
   */
  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
    Optional<Farm> farm = farmService.findById(id);
    if (farm.isEmpty()) {
      return ResponseEntity.status(404).body("Fazenda não encontrada!");
    } else {
      return ResponseEntity.status(200).body(farm);
    }
  }

  /**
   * create Crops.
   */

  @PostMapping("/{farmId}/crops")
  public ResponseEntity<Object> createCrop(
      @PathVariable("farmId") Integer farmId,
      @RequestBody CropDto cropDto) {
    try {
      CropDto createdCrop = cropService.createCrop(farmId, cropDto);
      return ResponseEntity.status(201).body(createdCrop);
    } catch (RuntimeException error) {
      return ResponseEntity.status(404).body("Fazenda não encontrada!");
    }
  }

  /**
   * get Crops by farmid.
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<Object> getCropsByFarm(
      @PathVariable("farmId") Integer farmId) {
    List<CropDto> crops;
    try {
      crops = cropService.cropsByFarm(farmId);
      return ResponseEntity.status(200).body(crops);
    } catch (RuntimeException error) {
      return ResponseEntity.status(404).body("Fazenda não encontrada!");
    }

  }


}
