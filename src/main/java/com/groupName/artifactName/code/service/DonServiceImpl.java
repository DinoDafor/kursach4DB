package com.groupName.artifactName.code.service;

import com.groupName.artifactName.code.models.Don;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.groupName.artifactName.code.repo.DonRepository;

import java.util.List;


@Service
public class DonServiceImpl implements DonServices {


    @Autowired
    private DonRepository donRepository;

    @Override
    public void create(Don don) {
        donRepository.save(don);
    }

    @Override
    public List<Don> readAll() {
        return donRepository.findAll();
    }

    @Override
    public Don read(int id) {
        return donRepository.getOne(id);
    }

    @Override
    public boolean update(Don don, int id) {
        if (donRepository.existsById(id)) {
            don.setId(id);
            donRepository.save(don);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (donRepository.existsById(id)) {
            donRepository.deleteById(id);
            return true;
        }
        return false;
    }
}