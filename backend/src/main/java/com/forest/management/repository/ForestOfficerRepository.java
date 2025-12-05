package com.forest.management.repository;

import com.forest.management.entity.ForestOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForestOfficerRepository extends JpaRepository<ForestOfficer, Integer> {
    Optional<ForestOfficer> findByEmployeeId(String employeeId);
    List<ForestOfficer> findByAssignedZone(String assignedZone);
    List<ForestOfficer> findByStatus(String status);
    List<ForestOfficer> findByDepartment(String department);
    List<ForestOfficer> findByDesignation(String designation);
}
