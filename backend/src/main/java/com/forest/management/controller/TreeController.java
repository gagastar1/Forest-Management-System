package com.forest.management.controller;

import com.forest.management.entity.Tree;
import com.forest.management.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
@CrossOrigin(origins = "*")
public class TreeController {
    
    @Autowired
    private TreeService treeService;
    
    @GetMapping
    public ResponseEntity<List<Tree>> getAllTrees() {
        return ResponseEntity.ok(treeService.getAllTrees());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Tree> getTreeById(@PathVariable Integer id) {
        return treeService.getTreeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Tree> createTree(@RequestBody Tree tree) {
        Tree created = treeService.createTree(tree);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Tree> updateTree(@PathVariable Integer id, @RequestBody Tree tree) {
        try {
            Tree updated = treeService.updateTree(id, tree);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTree(@PathVariable Integer id) {
        treeService.deleteTree(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/zone/{zone}")
    public ResponseEntity<List<Tree>> getTreesByZone(@PathVariable String zone) {
        return ResponseEntity.ok(treeService.getTreesByZone(zone));
    }
    
    @GetMapping("/health-status/{status}")
    public ResponseEntity<List<Tree>> getTreesByHealthStatus(@PathVariable String status) {
        return ResponseEntity.ok(treeService.getTreesByHealthStatus(status));
    }
}
