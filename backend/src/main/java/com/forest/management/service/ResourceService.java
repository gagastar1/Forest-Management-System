package com.forest.management.service;

import com.forest.management.entity.Resource;
import com.forest.management.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    
    @Autowired
    private ResourceRepository resourceRepository;
    
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
    
    public Optional<Resource> getResourceById(Integer id) {
        return resourceRepository.findById(id);
    }
    
    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }
    
    public Resource updateResource(Integer id, Resource resourceDetails) {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found with id: " + id));
        
        resource.setResourceName(resourceDetails.getResourceName());
        resource.setResourceType(resourceDetails.getResourceType());
        resource.setQuantity(resourceDetails.getQuantity());
        resource.setUnit(resourceDetails.getUnit());
        resource.setLocation(resourceDetails.getLocation());
        resource.setAssignedZone(resourceDetails.getAssignedZone());
        resource.setAssignedOfficer(resourceDetails.getAssignedOfficer());
        resource.setConditionStatus(resourceDetails.getConditionStatus());
        resource.setPurchaseDate(resourceDetails.getPurchaseDate());
        resource.setLastMaintenanceDate(resourceDetails.getLastMaintenanceDate());
        resource.setNextMaintenanceDate(resourceDetails.getNextMaintenanceDate());
        resource.setCost(resourceDetails.getCost());
        
        return resourceRepository.save(resource);
    }
    
    public void deleteResource(Integer id) {
        resourceRepository.deleteById(id);
    }
    
    public List<Resource> getResourcesByZone(String zone) {
        return resourceRepository.findByAssignedZone(zone);
    }
    
    public List<Resource> getResourcesByType(String type) {
        return resourceRepository.findByResourceType(type);
    }
}
