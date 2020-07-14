package com.testshop.dao.impl;

import com.testshop.dao.api.CategoryDAO;
import com.testshop.model.Category;
import com.testshop.model.Goods;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Component
public class CategoryDAOImpl implements CategoryDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category add(Category category) {
        entityManager.persist(category);
        category = entityManager.find(Category.class, category.getId());
        entityManager.refresh(category);
        return category;
    }

    @Override
    public List<Category> getAll() {
        return entityManager.createQuery("from Category ").getResultList();
    }

    @Override
    public Category getById(Long id) {
        Query query = entityManager.createQuery("FROM Category cat where cat.id=:id");
        query.setParameter("id", id);
        return (Category) query.getResultList().toArray()[0];
    }

    @Override
    public void update(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }
}
