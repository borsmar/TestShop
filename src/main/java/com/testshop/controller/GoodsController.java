package com.testshop.controller;

import com.testshop.dto.CategoryDto;
import com.testshop.dto.GoodsDto;
import com.testshop.model.Category;
import com.testshop.service.api.CategoryService;
import com.testshop.service.api.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/Goods")
public class GoodsController {

    Long id;


    @Autowired
    private GoodsService goodsService;


    @GetMapping(value = "/")
    public ModelAndView get(HttpServletRequest request) {


        ModelAndView model = new ModelAndView("Goods");
        return model;
    }

    @GetMapping(value = "/Item")
    public ModelAndView getItem(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
        GoodsDto goodsDto = goodsService.getById(id);

        ModelAndView model = new ModelAndView("Item");
        model.addObject("item", goodsDto);

        return model;

    }


}
