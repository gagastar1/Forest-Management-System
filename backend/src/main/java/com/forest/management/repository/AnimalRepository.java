package com.forest.management.repository;

import com.forest.management.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByZone(String zone);
    List<Animal> findByConservationStatus(String conservationStatus);
    List<Animal> findBySpeciesType(String speciesType);
    List<Animal> findByNameContainingIgnoreCase(String name);
}
