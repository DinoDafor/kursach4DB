package com.groupName.artifactName.code.repo;


import com.groupName.artifactName.code.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Procedure
    boolean giveOrder(Integer don_id, Integer order_id, boolean with_consiglieri);

    //select don from family where name = 'Corleone';
    @Query(value = "SELECT don FROM family f WHERE f.name = :name", nativeQuery = true)
    Integer findDonByFamily(@Param("name") String familyName);

    @Query(value = "SELECT name FROM family f WHERE f.don = :don", nativeQuery = true)
    String findFamilyByDon(@Param("don") Integer donId);


}
