package com.teksystems.capstone.controller;


import com.teksystems.capstone.database.dao.OrderDAO;
import com.teksystems.capstone.database.dao.OrderDetailsDAO;
import com.teksystems.capstone.database.dao.ProductDAO;
import com.teksystems.capstone.database.dao.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class CheckoutController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private ProductDAO productDAO;


    @GetMapping(value = "/checkout/info")
    public ModelAndView checkoutInformation() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("checkout/checkoutInformation");

        return response;
    }

}
