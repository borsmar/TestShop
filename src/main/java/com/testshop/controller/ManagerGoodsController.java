package com.testshop.controller;

import com.testshop.dto.CategoryDto;
import com.testshop.dto.GoodsDto;
import com.testshop.model.Category;
import com.testshop.service.api.CategoryService;
import com.testshop.service.api.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/GoodsManager")
public class ManagerGoodsController {

    Long id ;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public ModelAndView add(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
//        id = Long.parseLong("1");
        List<GoodsDto> listGoods = goodsService.getAll(id);
       List<CategoryDto> listCategories = categoryService.getAll();

        ModelAndView model = new ModelAndView("addGoods");
        model.addObject("goods", listGoods);
        model.addObject("categories", listCategories);
        model.addObject("id", id);
        model.addObject("goodsDto", new GoodsDto());
        model.addObject("categoryDto", new CategoryDto());
        return model;
    }

    @PostMapping(value = "/get")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException{
        id = Long.parseLong(request.getParameter("id"));
        response.sendRedirect("redirect:/GoodsManager/?id=" + id);
    }

//    /**
//     * send assignmentDto data from client
//     * to the server and send
//     * it to the assignmentService.
//     * Then update the list of events.
//     *
//     * @param assignmentDto
//     * @return ModelandView
//     * @throws JMSException
//     */
    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("goodsDto") GoodsDto goodsDto) throws JMSException {
        goodsDto.setCategory_id(id);
        goodsService.add(goodsDto);

        return new ModelAndView("redirect:/GoodsManager/?id="+id);
    }
//
//    /**
//     * Displaying the jsp page "editAssignment"
//     * at the url address http://localhost:8080/edit?id=?
//     * and passing the object AssignmentDto
//     * from database there
//     *
//     * @return
//     */
//    @GetMapping(value = "/edit")
//    public ModelAndView edit(HttpServletRequest request) throws Exception {
//        id = Long.parseLong(request.getParameter("id"));
//        AssignmentDto assignmentDto = assignmentService.getById(id);
//        ModelAndView model = new ModelAndView("editAssignment");
//        model.addObject("assignmentDto", assignmentDto);
//        return model;
//    }
//
//    /**
//     * update AsssignmentDto
//     *
//     * @param assignmentDto
//     * @return ModelAndView
//     */
//    @PostMapping(value = "/edit")
//    public ModelAndView edit(@ModelAttribute("assignment") AssignmentDto assignmentDto) throws JMSException {
//        assignmentDto.setId(id);
//        assignmentService.update(assignmentDto);
//        Long patientId = assignmentService.getPatientId(id);
//        eventService.sendUpdatedEvents();
//        return new ModelAndView("redirect:/patients/assignments?id=" + patientId);
//    }
//
//    /**
//     * delete Assignment and update table of Events
//     *
//     * @param request
//     * @return
//     * @throws JMSException
//     */
//    @GetMapping(value = "/delete")
//    public ModelAndView delete(HttpServletRequest request) throws JMSException {
//        id = Long.parseLong(request.getParameter("id"));
//        Long categoryId = goodsService.getCategoryId(id);
//        goodsService.deleteById(id);
//        return new ModelAndView("redirect:/patients/assignments?id=" + categoryId);
//    }
}
