package com.testshop.controller;

import com.testshop.dto.CategoryDto;
import com.testshop.dto.GoodsDto;
import com.testshop.service.api.CategoryService;
import com.testshop.service.api.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value="/categories")
    public  List<CategoryDto> getAllCategoryDtos() throws JMSException {
        return categoryService.getAll();
    }

    @PostMapping(value="/categories")
    public  void CreateCategory(@RequestBody CategoryDto categoryDto) throws JMSException {
        categoryService.add(categoryDto);
    }

    @GetMapping(value="/categories/{id}")
    public  CategoryDto getCategoryDto(@PathVariable("id") String id) throws JMSException {
        return categoryService.getById(Long.parseLong(id));
    }

    @DeleteMapping(value="/categories/{id}")
    public  void DeleteCat(@PathVariable("id") String id) throws JMSException {
        categoryService.deleteById(Long.parseLong("id"));
    }

    @DeleteMapping(value = "/items/{id}")
    public   void delete(@PathVariable("id") String id) throws JMSException {
       goodsService.deleteById(Long.parseLong(id));
    }


    @GetMapping(value="/categories/{id}/items")
    public  List<GoodsDto> getGoodsByCategoryDtos(@PathVariable("id") String id) throws JMSException {
        return goodsService.getAll(Long.parseLong(id));
    }

    @GetMapping(value="/categories/{id}/items/brands")
    public  List<String> getBrandsByCategoryId(@PathVariable("id") String id) throws JMSException {
        return goodsService.getBrandsByCategoryId(Long.parseLong(id));
    }



    @GetMapping(value="/categories/{id}/items/{sort}/page/{page}")
    public  List<GoodsDto> getGoodsPage(@PathVariable("id") String id, @PathVariable("page") String page,@PathVariable("sort") String sort,@RequestParam String fromPrice,@RequestParam String toPrice, @RequestParam String brands) throws JMSException {
        return goodsService.sortByPrice(Long.parseLong(id), Integer.parseInt(page), sort, Integer.parseInt(fromPrice), Integer.parseInt(toPrice), brands);
    }

    @GetMapping(value = "/categories/{id}/items/countPages")
    public String countPages(@PathVariable("id") String id, @RequestParam String fromPrice,@RequestParam String toPrice, @RequestParam String brands){

    return  ""+goodsService.countPagesByCategory(Long.parseLong(id), Integer.parseInt(fromPrice), Integer.parseInt(toPrice), brands);

    }


    @GetMapping(value = "/items/{id}")
    public  GoodsDto getGoodsDtoById(@PathVariable("id") String id) throws JMSException {

        return goodsService.getById(Long.parseLong(id));
    }

    @PostMapping(value = "/categories/{id}/items")
    public  void createGoodsDto(@PathVariable("id") String id, @RequestBody GoodsDto goodsDto) throws JMSException{

        goodsDto.setCategory_id(Long.parseLong(id));


        goodsService.add(goodsDto);
    }



    @GetMapping(value = "/")
    public ModelAndView get(HttpServletRequest request) {
        return new ModelAndView("AjaxTest");
    }

}
