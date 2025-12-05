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
@Table(name = "ForestOfficers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForestOfficer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_id")
    private Integer officerId;
    
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    
    @Column(name = "employee_id", unique = true, nullable = false, length = 20)
    private String employeeId;
    
    @Column(name = "designation", length = 100)
    private String designation;
    
    @Column(name = "department", length = 100)
    private String department;
    
    @Column(name = "assigned_zone", length = 50)
    private String assignedZone;
    
    @Column(name = "contact_number", length = 15)
    private String contactNumber;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @Column(name = "joining_date")
    private LocalDate joiningDate;
    
    @Column(name = "status", length = 20)
    private String status = "Active";
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
