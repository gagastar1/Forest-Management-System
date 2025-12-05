package com.forest.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Animals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Integer animalId;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "scientific_name", nullable = false, length = 150)
    private String scientificName;
    
    @Column(name = "location", length = 200)
    private String location;
    
    @Column(name = "zone", length = 50)
    private String zone;
    
    @Column(name = "count")
    private Integer count = 0;
    
    @Column(name = "species_type", length = 50)
    private String speciesType;
    
    @Column(name = "conservation_status", length = 50)
    private String conservationStatus;
    
    @Column(name = "last_sighting_date")
    private LocalDate lastSightingDate;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
