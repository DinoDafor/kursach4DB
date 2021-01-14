package com.groupName.artifactName.code.service;

import com.groupName.artifactName.code.models.Recruitment;
import com.groupName.artifactName.code.repo.OrderRepository;
import com.groupName.artifactName.code.repo.RecruitmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecruitmentServiceImpl implements  RecruitmentService{
    @Autowired
    private RecruitmentRepository recruitmentRepository;

    @Override
    public void create(Recruitment recruitment) {

    }

    @Override
    public List<Recruitment> readAll() {
        return null;
    }

    @Override
    public Recruitment read(int id) {
        return null;
    }

    @Override
    public boolean update(Recruitment recruitment, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean recruit(String family, Integer soldierId) {
        Integer don_id = recruitmentRepository.findDonOffFamily(family);
        return  recruitmentRepository.recruit(don_id, soldierId, 3 );

    }
}
