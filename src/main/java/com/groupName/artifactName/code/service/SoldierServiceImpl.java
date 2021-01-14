package com.groupName.artifactName.code.service;



import com.groupName.artifactName.code.models.Soldier;
import com.groupName.artifactName.code.repo.SoldierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SoldierServiceImpl implements SoldierService{
    @Autowired
    private SoldierRepository soldierRepository;

    @Override
    public void create(Soldier soldier) {
        soldierRepository.save(soldier);
    }

    @Override
    public List<Soldier> readAll() {
        return soldierRepository.findAll();
    }

    @Override
    public Soldier read(int id) {
        return soldierRepository.getOne(id);
    }

    @Override
    public boolean update(Soldier soldier, int id) {
        if (soldierRepository.existsById(id)) {
            soldier.setId(id);
            soldierRepository.save(soldier);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (soldierRepository.existsById(id)) {
            soldierRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
