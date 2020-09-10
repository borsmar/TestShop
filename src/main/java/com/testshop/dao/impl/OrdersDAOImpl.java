package com.testshop.dao.impl;

import com.testshop.dao.api.OrdersDAO;
import com.testshop.model.Category;
import com.testshop.model.Goods;
import com.testshop.model.Orders;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class OrdersDAOImpl implements OrdersDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Orders add(Orders order) {
        entityManager.persist(order);
        order = entityManager.find(Orders.class, order.getId());
        entityManager.refresh(order);
        return order;
    }

    @Override
    public List<Orders> getAll() {
        return entityManager.createQuery("from Orders ").getResultList();
    }

    @Override
    public Orders getById(Long id) {
        Query query = entityManager.createQuery("FROM Orders ord where ord.id=:id");
        query.setParameter("id", id);
        return (Orders) query.getResultList().toArray()[0];
    }

    @Override
    public void update(Orders order) {
        entityManager.persist(order);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }
}
