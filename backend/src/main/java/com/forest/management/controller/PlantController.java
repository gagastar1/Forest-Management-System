package com.forest.management.controller;

import com.forest.management.entity.Plant;
import com.forest.management.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin(origins = "*")
public class PlantController {
    
    @Autowired
    private PlantService plantService;
    
    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        return ResponseEntity.ok(plantService.getAllPlants());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Integer id) {
        return plantService.getPlantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
        Plant created = plantService.createPlant(plant);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Integer id, @RequestBody Plant plant) {
        try {
            Plant updated = plantService.updatePlant(id, plant);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Integer id) {
        plantService.deletePlant(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/zone/{zone}")
    public ResponseEntity<List<Plant>> getPlantsByZone(@PathVariable String zone) {
        return ResponseEntity.ok(plantService.getPlantsByZone(zone));
    }
    
    @GetMapping("/medicinal")
    public ResponseEntity<List<Plant>> getMedicinalPlants() {
        return ResponseEntity.ok(plantService.getMedicinalPlants());
    }
}
