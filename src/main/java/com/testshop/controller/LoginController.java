package com.testshop.controller;

import com.testshop.model.login.Login;
import com.testshop.model.login.User;
import com.testshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        model.addObject("login", new Login());
        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            model.addObject("message", "Logged out from com.medapp successfully.");
        }

        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/index?logout";
    }

    //
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        model.addObject("msg", "You do not have permission to access this page!");
        model.setViewName("accessDenied");
        return model;
    }

    @PostMapping("/login")
    public ModelAndView filter(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView("addGoods");
        //User user = userService.validateUser(login);
        return model;
    }
}