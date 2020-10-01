package com.testshop.controller;

import com.testshop.dto.CategoryDto;
import com.testshop.dto.GoodsDto;
import com.testshop.model.Category;
import com.testshop.service.api.CategoryService;
import com.testshop.service.api.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/GoodsManager")
public class ManagerGoodsController {

    Long id;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public ModelAndView get() {

        List<GoodsDto> listGoods = goodsService.getAll(Long.parseLong("1"));

        List<CategoryDto> listCategories = categoryService.getAll();

        ModelAndView model = new ModelAndView("addGoods");
        model.addObject("goods", listGoods);
        model.addObject("categories", listCategories);
        model.addObject("id", id);
        model.addObject("goodsDto", new GoodsDto());
        model.addObject("categoryDto", new CategoryDto());
        model.addObject("category", new Category());
        return model;
    }


    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("goodsDto") GoodsDto goodsDto) throws JMSException {
        goodsDto.setCategory_id(id);
        goodsService.add(goodsDto);

        return new ModelAndView("redirect:/GoodsManager/?id=" + id);
    }


    @GetMapping(value = "/edit")
    public ModelAndView edit(HttpServletRequest request) throws Exception {
        id = Long.parseLong(request.getParameter("id"));
        GoodsDto goodsDto = goodsService.getById(id);
        ModelAndView model = new ModelAndView("editGoods");
        model.addObject("goodsDto", goodsDto);
        return model;
    }


    @PostMapping(value = "/edit")
    public ModelAndView edit(@ModelAttribute("assignment") GoodsDto goodsDto) throws JMSException {
        goodsDto.setId(id);
        goodsService.update(goodsDto);
        Long categoryId = goodsService.getCategoryId(id);

        return new ModelAndView("redirect:/GoodsManager/?id=" + categoryId);
    }


    @GetMapping(value = "/delete")
    public ModelAndView delete(HttpServletRequest request) throws JMSException {
        id = Long.parseLong(request.getParameter("id"));
        Long categoryId = goodsService.getCategoryId(id);
        goodsService.deleteById(id);
        return new ModelAndView("redirect:/GoodsManager/?id=" + categoryId);
    }


}
