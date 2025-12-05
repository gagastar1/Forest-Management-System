package com.forest.management.repository;

import com.forest.management.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {
    List<Visitor> findByVisitDate(LocalDate visitDate);
    List<Visitor> findByZoneVisited(String zoneVisited);
    List<Visitor> findByVisitorType(String visitorType);
    List<Visitor> findByVisitDateBetween(LocalDate startDate, LocalDate endDate);
}
