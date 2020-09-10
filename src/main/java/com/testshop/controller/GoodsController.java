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
    int page;
    int var = 1;
    String sort;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public ModelAndView get(HttpServletRequest request) {


//        List<GoodsDto> listGoods = goodsService.sortByPrice(id, page);

//        List<CategoryDto> listCategories = categoryService.getAll();

        ModelAndView model = new ModelAndView("Goods");
//        model.addObject("goods", listGoods);
//        model.addObject("categories", listCategories);
//        model.addObject("goodsDto", new GoodsDto());
//        model.addObject("categoryDto", new CategoryDto());
//        model.addObject("category", new Category());
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
