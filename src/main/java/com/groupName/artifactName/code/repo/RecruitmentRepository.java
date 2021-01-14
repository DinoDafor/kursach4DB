package com.groupName.artifactName.code.repo;


import com.groupName.artifactName.code.models.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer> {

    @Procedure
    boolean recruit(Integer don_id, Integer soldier_id, Integer cost );

    //select don from family where name = 'Corleone';
    @Query(value = "SELECT don FROM family f WHERE f.name = :name", nativeQuery = true)
    Integer findDonOffFamily(@Param("name") String familyName);

}
