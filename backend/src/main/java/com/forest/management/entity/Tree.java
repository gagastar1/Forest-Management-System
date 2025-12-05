package com.forest.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Trees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tree {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tree_id")
    private Integer treeId;
    
    @Column(name = "common_name", nullable = false, length = 100)
    private String commonName;
    
    @Column(name = "scientific_name", nullable = false, length = 150)
    private String scientificName;
    
    @Column(name = "location", length = 200)
    private String location;
    
    @Column(name = "zone", length = 50)
    private String zone;
    
    @Column(name = "height_meters", precision = 5, scale = 2)
    private BigDecimal heightMeters;
    
    @Column(name = "age_years")
    private Integer ageYears;
    
    @Column(name = "diameter_cm", precision = 6, scale = 2)
    private BigDecimal diameterCm;
    
    @Column(name = "health_status", length = 50)
    private String healthStatus;
    
    @Column(name = "plantation_date")
    private LocalDate plantationDate;
    
    @Column(name = "tree_type", length = 50)
    private String treeType;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
