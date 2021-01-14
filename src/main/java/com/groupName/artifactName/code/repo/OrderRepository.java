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


//    @Query("select Army army set army.country = :country where army.general = :hero ")
//    void setCountry(@Param("country") Country country, @Param("hero") Hero name);

}
