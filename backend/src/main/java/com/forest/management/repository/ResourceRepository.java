package com.forest.management.repository;

import com.forest.management.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    List<Resource> findByAssignedZone(String assignedZone);
    List<Resource> findByResourceType(String resourceType);
    List<Resource> findByConditionStatus(String conditionStatus);
    List<Resource> findByAssignedOfficer_OfficerId(Integer officerId);
}
