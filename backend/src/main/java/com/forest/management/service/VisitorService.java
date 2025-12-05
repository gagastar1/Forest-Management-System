package com.forest.management.service;

import com.forest.management.entity.Visitor;
import com.forest.management.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {
    
    @Autowired
    private VisitorRepository visitorRepository;
    
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
    
    public Optional<Visitor> getVisitorById(Integer id) {
        return visitorRepository.findById(id);
    }
    
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }
    
    public Visitor updateVisitor(Integer id, Visitor visitorDetails) {
        Visitor visitor = visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found with id: " + id));
        
        visitor.setFullName(visitorDetails.getFullName());
        visitor.setContactNumber(visitorDetails.getContactNumber());
        visitor.setEmail(visitorDetails.getEmail());
        visitor.setVisitDate(visitorDetails.getVisitDate());
        visitor.setEntryTime(visitorDetails.getEntryTime());
        visitor.setExitTime(visitorDetails.getExitTime());
        visitor.setVisitorType(visitorDetails.getVisitorType());
        visitor.setGroupSize(visitorDetails.getGroupSize());
        visitor.setPermitNumber(visitorDetails.getPermitNumber());
        visitor.setZoneVisited(visitorDetails.getZoneVisited());
        visitor.setPurpose(visitorDetails.getPurpose());
        
        return visitorRepository.save(visitor);
    }
    
    public void deleteVisitor(Integer id) {
        visitorRepository.deleteById(id);
    }
    
    public List<Visitor> getVisitorsByDate(LocalDate date) {
        return visitorRepository.findByVisitDate(date);
    }
    
    public List<Visitor> getVisitorsByZone(String zone) {
        return visitorRepository.findByZoneVisited(zone);
    }
}
