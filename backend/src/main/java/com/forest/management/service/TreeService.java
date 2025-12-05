package com.forest.management.service;

import com.forest.management.entity.Tree;
import com.forest.management.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreeService {
    
    @Autowired
    private TreeRepository treeRepository;
    
    public List<Tree> getAllTrees() {
        return treeRepository.findAll();
    }
    
    public Optional<Tree> getTreeById(Integer id) {
        return treeRepository.findById(id);
    }
    
    public Tree createTree(Tree tree) {
        return treeRepository.save(tree);
    }
    
    public Tree updateTree(Integer id, Tree treeDetails) {
        Tree tree = treeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tree not found with id: " + id));
        
        tree.setCommonName(treeDetails.getCommonName());
        tree.setScientificName(treeDetails.getScientificName());
        tree.setLocation(treeDetails.getLocation());
        tree.setZone(treeDetails.getZone());
        tree.setHeightMeters(treeDetails.getHeightMeters());
        tree.setAgeYears(treeDetails.getAgeYears());
        tree.setDiameterCm(treeDetails.getDiameterCm());
        tree.setHealthStatus(treeDetails.getHealthStatus());
        tree.setPlantationDate(treeDetails.getPlantationDate());
        tree.setTreeType(treeDetails.getTreeType());
        
        return treeRepository.save(tree);
    }
    
    public void deleteTree(Integer id) {
        treeRepository.deleteById(id);
    }
    
    public List<Tree> getTreesByZone(String zone) {
        return treeRepository.findByZone(zone);
    }
    
    public List<Tree> getTreesByHealthStatus(String healthStatus) {
        return treeRepository.findByHealthStatus(healthStatus);
    }
}
