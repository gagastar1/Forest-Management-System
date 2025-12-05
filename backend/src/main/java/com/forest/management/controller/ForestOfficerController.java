package com.forest.management.controller;

import com.forest.management.entity.ForestOfficer;
import com.forest.management.service.ForestOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
@CrossOrigin(origins = "*")
public class ForestOfficerController {
    
    @Autowired
    private ForestOfficerService officerService;
    
    @GetMapping
    public ResponseEntity<List<ForestOfficer>> getAllOfficers() {
        return ResponseEntity.ok(officerService.getAllOfficers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ForestOfficer> getOfficerById(@PathVariable Integer id) {
        return officerService.getOfficerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<ForestOfficer> createOfficer(@RequestBody ForestOfficer officer) {
        ForestOfficer created = officerService.createOfficer(officer);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ForestOfficer> updateOfficer(@PathVariable Integer id, @RequestBody ForestOfficer officer) {
        try {
            ForestOfficer updated = officerService.updateOfficer(id, officer);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOfficer(@PathVariable Integer id) {
        officerService.deleteOfficer(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/zone/{zone}")
    public ResponseEntity<List<ForestOfficer>> getOfficersByZone(@PathVariable String zone) {
        return ResponseEntity.ok(officerService.getOfficersByZone(zone));
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<ForestOfficer>> getActiveOfficers() {
        return ResponseEntity.ok(officerService.getActiveOfficers());
    }
}
