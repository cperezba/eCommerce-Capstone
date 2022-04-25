package com.teksystems.capstone.controller;


import com.teksystems.capstone.database.dao.ProductDAO;
import com.teksystems.capstone.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class ShopController {

    @Autowired
    private ProductDAO productDAO;


    @GetMapping(value = "shop/collections")
    public ModelAndView getCollections() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/shop/productCollections");

        return response;
    }

    @RequestMapping(value="/shop/collection", method = RequestMethod.GET)
    public ModelAndView getCollection() throws Exception {
        ModelAndView response = new ModelAndView();

        List<Product> products = productDAO.findAll();


        response.addObject("products", products);
        response.setViewName("/shop/productCollection");
        return response;
    }

    @RequestMapping(value="/shop/product/{productId}", method = RequestMethod.GET)
    public ModelAndView showProduct(@PathVariable("productId") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();

        Product product = productDAO.findById(productId);
        response.addObject(product);

        response.setViewName("shop/productPage");
        return response;
    }

}
