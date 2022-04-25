package com.teksystems.capstone.controller;

import com.teksystems.capstone.database.dao.OrderDAO;
import com.teksystems.capstone.database.dao.OrderDetailsDAO;
import com.teksystems.capstone.database.dao.ProductDAO;
import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.Order;
import com.teksystems.capstone.database.entity.OrderDetails;
import com.teksystems.capstone.database.entity.Product;
import com.teksystems.capstone.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Slf4j
@Controller
public class CartController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private ProductDAO productDAO;


    //@RequestParam

    @GetMapping(value = "/cart/addProduct/{productId}")
    public ModelAndView addProductToCart(@PathVariable("productId") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();

        //TODO Find session's user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDAO.findByEmail(username);
//        User user = userDAO.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());



        //TODO Open an Order
        Order order = orderDAO.findByUserAndOrderStatus(user, "PENDING");

        if (order == null) {
            order = new Order();
            order.setUser(user);
            order.setOrderStatus("PENDING");
            order = orderDAO.save(order);
        }


        //TODO Add product to order
        Product product = productDAO.findById(productId);
        OrderDetails cartItem = orderDetailsDAO.findByOrderAndProduct(order, product);

        if (cartItem == null) {
            cartItem = new OrderDetails();
            cartItem.setOrder(order);
            cartItem.setProduct(product);
            cartItem.setProductQuantity(1);
        } else {
            cartItem.setProductQuantity(cartItem.getProductQuantity() + 1);
        }


        log.info(cartItem.getProduct().getTitle());
        log.info(cartItem.getProduct().getAuthor());
        OrderDetails savedCartItem = orderDetailsDAO.save(cartItem);
        log.info(savedCartItem.getProduct().getTitle());


        response.setViewName("redirect:/index");
        return response;
    }


    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView showCart() throws Exception {
        ModelAndView response = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDAO.findByEmail(username);

        List<Map<String, Object>> cartProducts = orderDetailsDAO.getCartProducts(user.getId(), "PENDING");
        response.addObject("cartProducts", cartProducts);



        response.setViewName("cart/cart");
        return response;
    }


    //TODO Understand this

    @RequestMapping(value = "/cart/deleteProduct/{productId}", method = RequestMethod.GET)
    public ModelAndView removeProduct(@PathVariable("productId") Integer productId) throws Exception {

        OrderDetails product = orderDetailsDAO.findByProduct(productId);

        if ( product == null ) {
            log.info("selectedCartLine is null");
            // this is an error
        } else {

            orderDetailsDAO.delete(product);
            System.out.println("product removed from cart");
        }

        return new ModelAndView("redirect:/index");
    }
}
