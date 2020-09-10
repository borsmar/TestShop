package com.testshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.events.EventException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionController {


    public static final String DEFAULT_ERROR_VIEW = "404";

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity Not Found!")
    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handleEntityNotFoundException(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView(DEFAULT_ERROR_VIEW);
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(Exception e) {
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        return mav;
    }


    @ExceptionHandler(EventException.class)
    public ModelAndView eventErrorHandler(EventException e) {
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        return mav;
    }


}
