package com.forest.management.repository;

import com.forest.management.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Integer> {
    List<Tree> findByZone(String zone);
    List<Tree> findByHealthStatus(String healthStatus);
    List<Tree> findByTreeType(String treeType);
    List<Tree> findByCommonNameContainingIgnoreCase(String commonName);
}
