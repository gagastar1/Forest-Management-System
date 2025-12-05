package com.forest.management.service;

import com.forest.management.entity.ForestOfficer;
import com.forest.management.repository.ForestOfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForestOfficerService {
    
    @Autowired
    private ForestOfficerRepository officerRepository;
    
    public List<ForestOfficer> getAllOfficers() {
        return officerRepository.findAll();
    }
    
    public Optional<ForestOfficer> getOfficerById(Integer id) {
        return officerRepository.findById(id);
    }
    
    public ForestOfficer createOfficer(ForestOfficer officer) {
        return officerRepository.save(officer);
    }
    
    public ForestOfficer updateOfficer(Integer id, ForestOfficer officerDetails) {
        ForestOfficer officer = officerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Officer not found with id: " + id));
        
        officer.setFirstName(officerDetails.getFirstName());
        officer.setLastName(officerDetails.getLastName());
        officer.setEmployeeId(officerDetails.getEmployeeId());
        officer.setDesignation(officerDetails.getDesignation());
        officer.setDepartment(officerDetails.getDepartment());
        officer.setAssignedZone(officerDetails.getAssignedZone());
        officer.setContactNumber(officerDetails.getContactNumber());
        officer.setEmail(officerDetails.getEmail());
        officer.setJoiningDate(officerDetails.getJoiningDate());
        officer.setStatus(officerDetails.getStatus());
        
        return officerRepository.save(officer);
    }
    
    public void deleteOfficer(Integer id) {
        officerRepository.deleteById(id);
    }
    
    public List<ForestOfficer> getOfficersByZone(String zone) {
        return officerRepository.findByAssignedZone(zone);
    }
    
    public List<ForestOfficer> getActiveOfficers() {
        return officerRepository.findByStatus("Active");
    }
}
