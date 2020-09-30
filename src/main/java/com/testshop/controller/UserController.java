package com.testshop.controller;

import com.testshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@RestController
@RequestMapping("/profile")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public ModelAndView profile(HttpSession session, Model model) {



        return new ModelAndView("UserProfile");
    }


}