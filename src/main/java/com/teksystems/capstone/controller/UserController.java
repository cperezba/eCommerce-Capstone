package com.teksystems.capstone.controller;

import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.dao.UserRoleDAO;
import com.teksystems.capstone.database.entity.User;
import com.teksystems.capstone.database.entity.UserRole;
import com.teksystems.capstone.database.entrybeans.UserEntryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
//@PreAuthorize("hasAuthority('USER')")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/user/entry", method = RequestMethod.GET)
    public ModelAndView userEntry() throws Exception {
        ModelAndView response = new ModelAndView();

//        UserEntryBean entry = new UserEntryBean();
//        response.addObject(entry);


        response.setViewName("alphaTestingEntries/user");
        return response;
    }


    @RequestMapping(value = "/user/entrySubmit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView userEntrySubmit(@Valid UserEntryBean entry, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info( ((FieldError)error).getField() + " " +  error.getDefaultMessage());
            }

            // add the form back to the model so we can fill up the input fields
            // so the user can correct the input and does not have type it all again
            response.addObject("entry", entry);

            // add the error list to the model
            response.addObject("bindingResult", bindingResult);

            // because there is 1 or more error we do not want to process the logic below
            // that will create a new user in the database.   We want to show the register.jsp
            response.setViewName("alphaTestingEntries/user");
            return response;
        }

        User user = new User();

        user.setEmail(entry.getEmail());
        String password = passwordEncoder.encode(entry.getPassword());
        user.setPassword(password);
        user.setFirstName(entry.getFirstName());
        user.setLastName(entry.getLastName());
        user.setDateOfBirth(entry.getDateOfBirth());
        user.setAddressOne(entry.getAddressOne());
        user.setAddressTwo(entry.getAddressTwo());
        user.setAptNumber(entry.getAptNumber());
        user.setState(entry.getState());
        user.setZipCode(entry.getZipCode());
        userDAO.save(user);


        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");
        userRoleDAO.save(userRole);






        response.setViewName("redirect:/user/entry");
        return response;
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public ModelAndView getAllUsers() throws Exception {
        ModelAndView response = new ModelAndView();

        List<User> user = userDAO.findAll();


        response.addObject("user", user);
        response.setViewName("aTestingLists/user");
        return response;
    }
}
