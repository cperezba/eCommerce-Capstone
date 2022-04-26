package com.teksystems.capstone.database.dao;

import com.teksystems.capstone.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@Slf4j
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TestProductDAO {

    @Autowired
    private ProductDAO productDAO;

    //create product
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveProduct(){
        Product product = Product.builder().title("Plato's Republic").author("Plato").price(Float.valueOf(6.00F)).description("Greek Philosophy").build();
        Product product2 = Product.builder().title("Nichomachean Ethics").author("Aristotle").price(Float.valueOf(6.00F)).description("Greek Philosophy").build();
        productDAO.save(product);
        productDAO.save(product2);

        log.info(String.valueOf(product));

        Assertions.assertTrue(product.getId() > 0);
    }

    //read product
    @ParameterizedTest
    @Order(2)
    @ValueSource(strings = {"soft", "hardy"})
    public void findProductTest(String productCategory){
        List<Product> product = productDAO.findAll();
        org.junit.jupiter.api.Assertions.assertNotNull(product);
    }

    @Test
    @Order(3)
    public void getProductTest() {
        Product product = productDAO.findById(1);
        org.junit.jupiter.api.Assertions.assertEquals(1, product.getId());
    }
    @Test
    @Order(4)
    public void getProductListTest() {
        List<Product> productList = productDAO.findAll();
        org.junit.jupiter.api.Assertions.assertTrue(productList.size() > 0);
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void updateProductTest() {
        Product product = productDAO.findById(1);
        product.setTitle("Plato's Republic");
        org.junit.jupiter.api.Assertions.assertEquals(productDAO.findById(1).getTitle(), product.getTitle());
    }
    @Test
    @Order(6)
    @Rollback(value = false)
    public void deleteProductTest(){
        Product product = productDAO.findById(1);
        productDAO.delete(product);
        Optional<Product> optionalUser = Optional.ofNullable(productDAO.findById(product.getId()));
        Product temporaryProduct = null;
        if(optionalUser.isPresent()){
            temporaryProduct = productDAO.findById(product.getId());
        }
        Assertions.assertNull(temporaryProduct);
    }
}