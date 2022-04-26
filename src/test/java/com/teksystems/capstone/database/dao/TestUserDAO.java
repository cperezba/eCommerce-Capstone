package com.teksystems.capstone.database.dao;

import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.User;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;


@Slf4j
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TestUserDAO {

    @Autowired
    private UserDAO userDAO;

    //create user
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUser(){
        User user = User.builder().firstName("John").lastName("Smith").email("john.smith@gmail.com").password("password").build();
        User user2 = User.builder().firstName("Jane").lastName("Doe").email("jdoe@gmail.com").password("password").build();
        userDAO.save(user);
        userDAO.save(user2);

        log.info(String.valueOf(user));

        Assertions.assertTrue(user.getId() > 0);
    }

    //read users
    @ParameterizedTest
    @Order(2)
    @ValueSource(strings = {"john.smith@gmail.com", "jdoe@gmail.com"})
    public void findUserTest(String email){
        User user = userDAO.findByEmail(email);
        Assertions.assertNotNull(user);
    }

    @Test
    @Order(3)
    public void getUserTest() {
        User user = userDAO.findById(1);
        Assertions.assertEquals(1, user.getId());
    }
    @Test
    @Order(4)
    public void getUserListTest() {
        List<User> userList = userDAO.findAll();
        Assertions.assertTrue(userList.size() > 0);
    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void updateUserTest() {
        User user = userDAO.findById(1);
        user.setFirstName("Henry");
        Assertions.assertEquals(userDAO.findById(1).getFirstName(), user.getFirstName());
    }
    @Test
    @Order(6)
    @Rollback(value = false)
    public void deleteUserTest(){
        User user = userDAO.findById(1);
        userDAO.delete(user);
        Optional<User> optionalUser = Optional.ofNullable(userDAO.findById(user.getId()));
        User temporaryUser = null;
        if(optionalUser.isPresent()){
            temporaryUser = userDAO.findById(user.getId());
        }
        Assertions.assertNull(temporaryUser);
    }
}