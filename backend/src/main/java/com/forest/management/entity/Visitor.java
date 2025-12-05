package com.forest.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Visitors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visitor_id")
    private Integer visitorId;
    
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;
    
    @Column(name = "contact_number", length = 15)
    private String contactNumber;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @Column(name = "visit_date", nullable = false)
    private LocalDate visitDate;
    
    @Column(name = "entry_time")
    private LocalTime entryTime;
    
    @Column(name = "exit_time")
    private LocalTime exitTime;
    
    @Column(name = "visitor_type", length = 50)
    private String visitorType;
    
    @Column(name = "group_size")
    private Integer groupSize = 1;
    
    @Column(name = "permit_number", length = 50)
    private String permitNumber;
    
    @Column(name = "zone_visited", length = 50)
    private String zoneVisited;
    
    @Column(name = "purpose", length = 200)
    private String purpose;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
