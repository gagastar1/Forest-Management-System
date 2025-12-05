package com.forest.management.service;

import com.forest.management.entity.Plant;
import com.forest.management.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {
    
    @Autowired
    private PlantRepository plantRepository;
    
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }
    
    public Optional<Plant> getPlantById(Integer id) {
        return plantRepository.findById(id);
    }
    
    public Plant createPlant(Plant plant) {
        return plantRepository.save(plant);
    }
    
    public Plant updatePlant(Integer id, Plant plantDetails) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));
        
        plant.setCommonName(plantDetails.getCommonName());
        plant.setScientificName(plantDetails.getScientificName());
        plant.setLocation(plantDetails.getLocation());
        plant.setZone(plantDetails.getZone());
        plant.setPlantType(plantDetails.getPlantType());
        plant.setCoverageAreaSqm(plantDetails.getCoverageAreaSqm());
        plant.setFloweringSeason(plantDetails.getFloweringSeason());
        plant.setMedicinalUse(plantDetails.getMedicinalUse());
        plant.setCount(plantDetails.getCount());
        
        return plantRepository.save(plant);
    }
    
    public void deletePlant(Integer id) {
        plantRepository.deleteById(id);
    }
    
    public List<Plant> getPlantsByZone(String zone) {
        return plantRepository.findByZone(zone);
    }
    
    public List<Plant> getMedicinalPlants() {
        return plantRepository.findByMedicinalUse(true);
    }
}
