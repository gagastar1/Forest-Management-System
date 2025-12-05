package com.forest.management.controller;

import com.forest.management.entity.Animal;
import com.forest.management.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@CrossOrigin(origins = "*")
public class AnimalController {
    
    @Autowired
    private AnimalService animalService;
    
    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        return ResponseEntity.ok(animalService.getAllAnimals());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Integer id) {
        return animalService.getAnimalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal created = animalService.createAnimal(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        try {
            Animal updated = animalService.updateAnimal(id, animal);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Integer id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/zone/{zone}")
    public ResponseEntity<List<Animal>> getAnimalsByZone(@PathVariable String zone) {
        return ResponseEntity.ok(animalService.getAnimalsByZone(zone));
    }
    
    @GetMapping("/conservation-status/{status}")
    public ResponseEntity<List<Animal>> getAnimalsByConservationStatus(@PathVariable String status) {
        return ResponseEntity.ok(animalService.getAnimalsByConservationStatus(status));
    }
}
