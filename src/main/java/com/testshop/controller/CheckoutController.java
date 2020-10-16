package com.testshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CheckoutController {

    @GetMapping(value = "/")
    public ModelAndView cart(HttpSession session, Model model) {

        return new ModelAndView("cart");
    }

}
