package com.teksystems.capstone.database.dao;


import com.teksystems.capstone.database.entity.Order;
import com.teksystems.capstone.database.entity.OrderDetails;
import com.teksystems.capstone.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Long> {


    @Query(value = "SELECT p.id, p.title, p.image, p.price, od.quantity, o.id \n" +
            "AS order_id, (p.price * od.quantity) AS total\n" +
            "FROM products p, order_details od, orders o \n" +
            "WHERE p.id = od.product_id AND o.id = od.order_id  AND o.user_id = :userId AND o.order_status = :cartStatus", nativeQuery = true)
    List<Map<String, Object>> getCartProducts(@Param("userId") Integer userId, @Param("cartStatus") String cartStatus);

    public OrderDetails findByProduct(@Param("productId") Integer productId);

    public OrderDetails findById(@Param("id") Integer id);  //How would this work with identifying foreign keys?

    public List<OrderDetails> findByOrder(@Param("order") Order order);

    public OrderDetails findByOrderAndProduct(@Param("order") Order order, @Param("product") Product product);
}
