package com.teksystems.capstone.controller;


import com.teksystems.capstone.database.dao.ProductDAO;
import com.teksystems.capstone.database.entity.Product;
import com.teksystems.capstone.database.entrybeans.ProductEntryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/product/entry", method = RequestMethod.GET)
    public ModelAndView productEntry() throws Exception {
        ModelAndView response = new ModelAndView();

        ProductEntryBean entry = new ProductEntryBean();
        response.addObject(entry);


        response.setViewName("product/entry");
        return response;
    }


    @RequestMapping(value = "/product/entrySubmit", method = RequestMethod.POST)
    public ModelAndView productEntrySubmit(ProductEntryBean entry) throws Exception {
        ModelAndView response = new ModelAndView();

        Product product = new Product();

        product.setId(entry.getId());
        product.setTitle(entry.getTitle());
        product.setAuthor(entry.getAuthor());
        product.setDescription(entry.getDescription());
        product.setImage(entry.getImage());
        product.setPublisher(entry.getPublisher());
        product.setIsbn10(entry.getIsbn10());
        product.setIsbn13(entry.getIsbn13());
        product.setPrice(entry.getPrice());
        product.setDiscount(entry.getDiscount());
        product.setStatus(entry.getStatus());
        product.setQuantity(entry.getQuantity());
        product.setItemCondition(entry.getItemCondition());

        productDAO.save(product);

        response.setViewName("redirect:/product/entry");
        return response;
    }


    @RequestMapping(value="/product/list", method = RequestMethod.GET)
    public ModelAndView getAllProducts() throws Exception {
        ModelAndView response = new ModelAndView();

        List<Product> products = productDAO.findAll();


        response.addObject("products", products);
        response.setViewName("/product/all");
        return response;
    }
}
