package com.forest.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Plants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_id")
    private Integer plantId;
    
    @Column(name = "common_name", nullable = false, length = 100)
    private String commonName;
    
    @Column(name = "scientific_name", nullable = false, length = 150)
    private String scientificName;
    
    @Column(name = "location", length = 200)
    private String location;
    
    @Column(name = "zone", length = 50)
    private String zone;
    
    @Column(name = "plant_type", length = 50)
    private String plantType;
    
    @Column(name = "coverage_area_sqm", precision = 8, scale = 2)
    private BigDecimal coverageAreaSqm;
    
    @Column(name = "flowering_season", length = 50)
    private String floweringSeason;
    
    @Column(name = "medicinal_use")
    private Boolean medicinalUse = false;
    
    @Column(name = "count")
    private Integer count = 0;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
