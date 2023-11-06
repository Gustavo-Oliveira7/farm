package com.betrybe.agrix.controllers;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
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
 * FertilizerRepository.
 */

@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  @Autowired
  private CropRepository cropRepository;
  @Autowired
  private FertilizerRepository fertilizerRepository;

  @PostMapping
  public ResponseEntity<Fertilizer> createFertilizer(
      @RequestBody Fertilizer fertilizer
  ) {
    Fertilizer fertilizerResponse = fertilizerRepository.save(fertilizer);
    return ResponseEntity.status(201).body(fertilizerResponse);
  }

  @GetMapping
  public List<Fertilizer> getAllFerrilizers() {
    List<Fertilizer> fertilizers = fertilizerRepository.findAll();
    return fertilizers;
  }

  /**
   * get fertilizers by Id.
   */


  @GetMapping("/{id}")
  public ResponseEntity getFertilizerById(@PathVariable Integer id) {
    Optional<Fertilizer> fertilizer = fertilizerRepository.findById(id);
    if (fertilizer.isEmpty()) {
      return ResponseEntity.status(404).body("Fertilizante não encontrado!");
    } else {
      return ResponseEntity.status(200).body(fertilizer);
    }
  }


}
