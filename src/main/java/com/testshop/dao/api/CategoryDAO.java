package com.testshop.dao.api;

import com.testshop.dto.CategoryDto;
import com.testshop.model.Category;

import java.util.List;

public interface CategoryDAO {
    Category add(Category category);

    List<Category> getAll();

    Category getById(Long id);

    void update(Category category);

    void delete(Long id);
}
