package com.testshop.controller;

import com.testshop.dto.AddressDto;
import com.testshop.dto.CategoryDto;
import com.testshop.dto.GoodsDto;
import com.testshop.dto.UserDto;
import com.testshop.service.api.AddressService;
import com.testshop.service.api.CategoryService;
import com.testshop.service.api.GoodsService;
import com.testshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    AddressService addressService;

    @GetMapping(value = "/categories")
    public List<CategoryDto> getAllCategoryDtos() throws JMSException {
        return categoryService.getAll();
    }

    @PostMapping(value = "/categories")
    public void CreateCategory(@RequestBody CategoryDto categoryDto) throws JMSException {
        categoryService.add(categoryDto);
    }

    @GetMapping(value = "/categories/{id}")
    public CategoryDto getCategoryDto(@PathVariable("id") String id) throws JMSException {
        return categoryService.getById(Long.parseLong(id));
    }

    @DeleteMapping(value = "/categories/{id}")
    public void DeleteCat(@PathVariable("id") String id) throws JMSException {
        categoryService.deleteById(Long.parseLong("id"));
    }

    @DeleteMapping(value = "/items/{id}")
    public void delete(@PathVariable("id") String id) throws JMSException {
        goodsService.deleteById(Long.parseLong(id));
    }


    @GetMapping(value = "/categories/{id}/items")
    public List<GoodsDto> getGoodsByCategoryDtos(@PathVariable("id") String id) throws JMSException {
        return goodsService.getAll(Long.parseLong(id));
    }

    @GetMapping(value = "/categories/{id}/items/brands")
    public List<String> getBrandsByCategoryId(@PathVariable("id") String id) throws JMSException {
        return goodsService.getBrandsByCategoryId(Long.parseLong(id));
    }


    @GetMapping(value = "/categories/{id}/items/{sort}/page/{page}")
    public List<GoodsDto> getGoodsPage(@PathVariable("id") String id, @PathVariable("page") String page, @PathVariable("sort") String sort, @RequestParam String fromPrice, @RequestParam String toPrice, @RequestParam String brands) throws JMSException {
        return goodsService.sortByPrice(Long.parseLong(id), Integer.parseInt(page), sort, Integer.parseInt(fromPrice), Integer.parseInt(toPrice), brands);
    }

    @GetMapping(value = "/categories/{id}/items/countPages")
    public String countPages(@PathVariable("id") String id, @RequestParam String fromPrice, @RequestParam String toPrice, @RequestParam String brands) {

        return "" + goodsService.countPagesByCategory(Long.parseLong(id), Integer.parseInt(fromPrice), Integer.parseInt(toPrice), brands);

    }


    @GetMapping(value = "/items/{id}")
    public GoodsDto getGoodsDtoById(@PathVariable("id") String id) throws JMSException {

        return goodsService.getById(Long.parseLong(id));
    }

    @PostMapping(value = "/categories/{id}/items")
    public void createGoodsDto(@PathVariable("id") String id, @RequestBody GoodsDto goodsDto) throws JMSException {

        goodsDto.setCategory_id(Long.parseLong(id));

        goodsService.add(goodsDto);
    }

    @GetMapping(value = "/current_user")
    public UserDto getCurrentUser() {
        return userService.findByUsername(userService.GetCurrentUsername());
    }

    @GetMapping(value = "/updateuser")
    public void updateUserPassword(@RequestParam String username, @RequestParam String password, @RequestParam String currentPassword) {
        userService.changeUserPassword(userService.findByUsername(username), password, currentPassword);
    }




    @PatchMapping(value = "/current_user/{id}")
    public ResponseEntity<String> updateCurrentUser(@PathVariable String id,@RequestBody UserDto userDto) throws JMSException {


        userDto.setId(Long.parseLong(id));

        if (userService.getById(Long.parseLong(id)) == null) {
            return new ResponseEntity<String>("Account not found", HttpStatus.NOT_FOUND);
        } else {
            userService.update(userDto);
            return new ResponseEntity<String>("Account successfully updated", HttpStatus.OK);
        }
        // UserDto userDto = new UserDto();

        // userDto.setId(Long.parseLong(id));
        // userDto.setFirstName(firstName);


    }

    @DeleteMapping(value = "/current_user/address/{id}")
    public void deleteAddress(@PathVariable String id,@RequestBody UserDto userDto) throws JMSException {
            userService.deleteAddress(userDto, id);
    }

    @PatchMapping(value = "/current_user/{userid}/address/{id}")
    public void updateAddress(@PathVariable String userid, @PathVariable String id,@RequestBody AddressDto addressDto) throws JMSException {
        userService.updateAddress(addressDto,userid, id);
    }

    @PostMapping(value = "/address/{id}")
    public void createAddress(@PathVariable("id") String id,@RequestBody AddressDto addressDto){

        addressService.add(addressDto, id);

    }

    @GetMapping(value = "/")
    public ModelAndView get(HttpServletRequest request) {
        return new ModelAndView("AjaxTest");
    }

}
