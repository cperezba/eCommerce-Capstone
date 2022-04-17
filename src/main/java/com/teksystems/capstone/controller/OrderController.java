package com.teksystems.capstone.controller;


import com.teksystems.capstone.database.dao.OrderDAO;
import com.teksystems.capstone.database.entity.Order;
import com.teksystems.capstone.database.entrybeans.OrderEntryBean;
import com.teksystems.capstone.database.entrybeans.UserEntryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(value = "/entries/order", method = RequestMethod.GET)
    public ModelAndView orderEntry() throws Exception {
        ModelAndView response = new ModelAndView();

        OrderEntryBean entry = new OrderEntryBean();
        response.addObject(entry);


        response.setViewName("aTestingEntries/order");
        return response;
    }


    @RequestMapping(value = "/order/entrySubmit", method = RequestMethod.POST)
    public ModelAndView orderEntrySubmit(OrderEntryBean entry) throws Exception {
        ModelAndView response = new ModelAndView();

        Order order = new Order();
        order.setSubTotal(entry.getSubTotal());
        order.setTotal(entry.getTotal());
        order.setPaymentType(entry.getPaymentType());
        order.setCardName(entry.getCardName());
        order.setCardNumber(entry.getCardNumber());
        order.setCardExpirationDate(entry.getCardExpirationDate());
        order.setCvsCode(entry.getCvsCode());

        orderDAO.save(order);

        response.setViewName("redirect:/entries/order");
        return response;
    }


    @RequestMapping(value = "/order/all", method = RequestMethod.GET)
    public ModelAndView getAllUsers() throws Exception {
        ModelAndView response = new ModelAndView();

        List<Order> order = orderDAO.findAll();




        response.addObject("order", order);
        response.setViewName("aTestingLists/order");
        return response;
    }

}
