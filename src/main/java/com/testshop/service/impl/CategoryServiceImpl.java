package com.testshop.service.impl;

import com.testshop.dao.api.CategoryDAO;
import com.testshop.dto.CategoryDto;
import com.testshop.dto.GoodsDto;
import com.testshop.model.Category;
import com.testshop.model.Goods;
import com.testshop.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.List;

import static com.testshop.service.impl.GoodsServiceImpl.convertDtoToGoods;
import static com.testshop.service.impl.GoodsServiceImpl.convertGoodsToDto;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    @Transactional
    public List<CategoryDto> getAll() {
        List<Category> categoryList = categoryDAO.getAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category category : categoryList){
            CategoryDto categoryDto = convertCategoryToDto(category);
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    @Override
    @Transactional
    public CategoryDto getById(Long id) {
        Category cat = categoryDAO.getById(id);
        return convertCategoryToDto(cat);
    }

    @Override
    @Transactional
    public void add(CategoryDto categoryDto) {

        Category category = convertDtoToCategory(new Category(), categoryDto);

        categoryDAO.add(category);
    }

    @Override
    @Transactional
    public void update(CategoryDto categoryDto) throws JMSException {
        Category c = categoryDAO.getById(categoryDto.getId());
        c.setName(categoryDto.getName());

        List<Goods> goodsList = new ArrayList<>();

        for(GoodsDto goodsDtos : categoryDto.getGoodsDtos()){
            Goods goods = convertDtoToGoods(new Goods(), goodsDtos);
            goodsList.add(goods);
        }

        c.setGoods(goodsList);

        categoryDAO.update(c);
    }

    @Override
    @Transactional
    public void deleteById(Long categoryId) throws JMSException {
        categoryDAO.delete(categoryId);
    }

    public CategoryDto convertCategoryToDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        List<GoodsDto> goodsDtoList = new ArrayList<>();

        for(Goods goods : category.getGoods()){
            GoodsDto goodsDto = convertGoodsToDto(goods);
            goodsDtoList.add(goodsDto);
        }

        categoryDto.setGoodsDtos(goodsDtoList);

        return categoryDto;
    }

    public  Category convertDtoToCategory(Category category, CategoryDto categoryDto){


        category.setName(categoryDto.getName());


     if(categoryDto.getGoodsDtos() != null){

        List<Goods> goodsList = new ArrayList<>();
        for(GoodsDto goodsDtos : categoryDto.getGoodsDtos()){
            Goods goods = convertDtoToGoods(new Goods(),goodsDtos);
            goodsList.add(goods);
        }
        category.setGoods(goodsList);
         }


        return category;
    }


}
