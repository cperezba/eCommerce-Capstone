package com.teksystems.capstone.controller;

import com.teksystems.capstone.database.dao.ProductDAO;
import com.teksystems.capstone.database.entity.Order;
import com.teksystems.capstone.database.entity.Product;
import com.teksystems.capstone.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
public class CartController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView displayCart() throws Exception {
        ModelAndView response = new ModelAndView();

//        User user = new User();
//        user.setId(1);
//        user.setEmail("person@email.com");


//        Order orderOne = new Order();
//        orderOne.setUserID(1);
//
//        Order orderTwo = new Order();
//        orderTwo.setUserID(1);


//        log.info("Cart");


        response.setViewName("cart");
        return response;
    }


    @RequestMapping(value = "/cart/addItem", method = RequestMethod.POST)
    public ModelAndView addToCart(@RequestParam Integer productID) throws Exception {
        ModelAndView response = new ModelAndView();

        Product product = productDAO.findById(productID);

//        Order order = order.findByUserID where status == open
        //I. Status needs to be open, or item will be added to wrong order.

        //II. Conditional Statement: If order null, create new order

        //III. Create Order Details??




        response.setViewName("redirect:/product/all");
        return response;
    }
}
