package com.teksystems.capstone.controller;


import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserDAO userDAO;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();


        //Zoom:4/12/2022 1:50:00 Retrieving user's name from email(username)

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if ( authentication.isAuthenticated() ) {
//            String currentPrincipalName = authentication.getName();
//            User loggedInUser = userDAO.findByEmail(currentPrincipalName);
//        }
//
//        log.debug(currentPrincipalName);

        response.setViewName("index");
        return response;
    }
}
