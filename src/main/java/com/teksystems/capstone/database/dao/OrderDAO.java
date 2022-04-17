package com.teksystems.capstone.database.dao;


import com.teksystems.capstone.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

    public Order findById(@Param("id") Integer id);
}
