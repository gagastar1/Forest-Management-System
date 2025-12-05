package com.forest.management.service;

import com.forest.management.entity.Animal;
import com.forest.management.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    
    @Autowired
    private AnimalRepository animalRepository;
    
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }
    
    public Optional<Animal> getAnimalById(Integer id) {
        return animalRepository.findById(id);
    }
    
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }
    
    public Animal updateAnimal(Integer id, Animal animalDetails) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found with id: " + id));
        
        animal.setName(animalDetails.getName());
        animal.setScientificName(animalDetails.getScientificName());
        animal.setLocation(animalDetails.getLocation());
        animal.setZone(animalDetails.getZone());
        animal.setCount(animalDetails.getCount());
        animal.setSpeciesType(animalDetails.getSpeciesType());
        animal.setConservationStatus(animalDetails.getConservationStatus());
        animal.setLastSightingDate(animalDetails.getLastSightingDate());
        
        return animalRepository.save(animal);
    }
    
    public void deleteAnimal(Integer id) {
        animalRepository.deleteById(id);
    }
    
    public List<Animal> getAnimalsByZone(String zone) {
        return animalRepository.findByZone(zone);
    }
    
    public List<Animal> getAnimalsByConservationStatus(String status) {
        return animalRepository.findByConservationStatus(status);
    }
}
