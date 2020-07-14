package com.testshop.service.api;

import com.testshop.dto.CategoryDto;
import com.testshop.dto.GoodsDto;
import com.testshop.model.Category;

import javax.jms.JMSException;
import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAll();

    CategoryDto getById(Long id);

    void add(Category category);

    void update(CategoryDto category) throws JMSException;

    void deleteById(Long categoryId) throws JMSException;
}
