package com.groupName.artifactName.code.repo;


import com.groupName.artifactName.code.models.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldierRepository extends JpaRepository<Soldier, Integer> {
}
