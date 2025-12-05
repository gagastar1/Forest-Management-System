package com.forest.management.controller;

import com.forest.management.entity.Visitor;
import com.forest.management.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@CrossOrigin(origins = "*")
public class VisitorController {
    
    @Autowired
    private VisitorService visitorService;
    
    @GetMapping
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Integer id) {
        return visitorService.getVisitorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor visitor) {
        Visitor created = visitorService.createVisitor(visitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable Integer id, @RequestBody Visitor visitor) {
        try {
            Visitor updated = visitorService.updateVisitor(id, visitor);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Integer id) {
        visitorService.deleteVisitor(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/date/{date}")
    public ResponseEntity<List<Visitor>> getVisitorsByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(visitorService.getVisitorsByDate(date));
    }
    
    @GetMapping("/zone/{zone}")
    public ResponseEntity<List<Visitor>> getVisitorsByZone(@PathVariable String zone) {
        return ResponseEntity.ok(visitorService.getVisitorsByZone(zone));
    }
}
