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
@Table(name = "Resources")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_id")
    private Integer resourceId;
    
    @Column(name = "resource_name", nullable = false, length = 100)
    private String resourceName;
    
    @Column(name = "resource_type", length = 50)
    private String resourceType;
    
    @Column(name = "quantity")
    private Integer quantity = 0;
    
    @Column(name = "unit", length = 20)
    private String unit;
    
    @Column(name = "location", length = 200)
    private String location;
    
    @Column(name = "assigned_zone", length = 50)
    private String assignedZone;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_officer_id")
    private ForestOfficer assignedOfficer;
    
    @Column(name = "condition_status", length = 50)
    private String conditionStatus;
    
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;
    
    @Column(name = "last_maintenance_date")
    private LocalDate lastMaintenanceDate;
    
    @Column(name = "next_maintenance_date")
    private LocalDate nextMaintenanceDate;
    
    @Column(name = "cost", precision = 10, scale = 2)
    private BigDecimal cost;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
