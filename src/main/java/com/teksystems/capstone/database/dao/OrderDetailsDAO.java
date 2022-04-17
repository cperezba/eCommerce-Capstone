package com.teksystems.capstone.database.dao;


import com.teksystems.capstone.database.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Long> {

    public OrderDetails findById(@Param("id") Integer id);  //How would this work with identifying foreign keys?
}
