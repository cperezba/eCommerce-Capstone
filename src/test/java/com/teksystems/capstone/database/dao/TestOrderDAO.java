package com.teksystems.capstone.database.dao;

import com.teksystems.capstone.database.dao.OrderDAO;
import com.teksystems.capstone.database.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.query.Param;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TestOrderDAO {

    @Autowired
    private OrderDAO orderDAO;

    //create order
    @Test
    @org.junit.jupiter.api.Order(1)
    @Rollback(value = false)
    public void saveProduct(){
        Order order = Order.builder().orderStatus("PENDING").cardName("Aristotle").paymentType("Credit Card").cvsCode(123).build();
        Order order2 = Order.builder().orderStatus("COMPLETED").cardName("Plato").paymentType("CreditCard").cvsCode(123).build();
        orderDAO.save(order);
        orderDAO.save(order2);

        log.info(String.valueOf(order));

        Assertions.assertTrue(order.getId() > 0);
    }

    //read order
    @ParameterizedTest
    @org.junit.jupiter.api.Order(2)
    @ValueSource(strings = {"Aristotle", "Plato"})
    public void findOrderTest(String cardholderName){
        List<Order> order = orderDAO.findAll();
        Assertions.assertNotNull(order);
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void getOrderTest() {
        Order order = orderDAO.findById(1);
        Assertions.assertEquals(1, order.getId());
    }
    @Test
    @org.junit.jupiter.api.Order(4)
    public void getOrderListTest() {
        List<Order> orderList = orderDAO.findAll();
        Assertions.assertTrue(orderList.size() > 0);
    }
    @Test
    @org.junit.jupiter.api.Order(5)
    @Rollback(value = false)
    public void updateOrderTest() {
        Order order = orderDAO.findById(1);
        order.setOrderStatus("COMPLETED");
        Assertions.assertEquals(orderDAO.findById(1).getOrderStatus(), order.getOrderStatus());
    }
    @Test
    @org.junit.jupiter.api.Order(6)
    @Rollback(value = false)
    public void deleteOrderTest(){
        Order order = orderDAO.findById(1);
        orderDAO.delete(order);
        Optional<Order> optionalOrder = Optional.ofNullable(orderDAO.findById(order.getId()));
        Order temporaryOrder = null;
        if(optionalOrder.isPresent()){
            temporaryOrder = orderDAO.findById(order.getId());
        }
        Assertions.assertNull(temporaryOrder);
    }
}