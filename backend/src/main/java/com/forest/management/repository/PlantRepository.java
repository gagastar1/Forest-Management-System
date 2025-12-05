package com.forest.management.repository;

import com.forest.management.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
    List<Plant> findByZone(String zone);
    List<Plant> findByPlantType(String plantType);
    List<Plant> findByMedicinalUse(Boolean medicinalUse);
    List<Plant> findByCommonNameContainingIgnoreCase(String commonName);
}
