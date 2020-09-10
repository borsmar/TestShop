package com.testshop.dao.impl;

import com.testshop.dao.api.CustomerDAO;
import com.testshop.model.Category;
import com.testshop.model.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer add(Customer customer) {
        entityManager.persist(customer);
        customer = entityManager.find(Customer.class, customer.getId());
        entityManager.refresh(customer);
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return entityManager.createQuery("from Customer ").getResultList();
    }

    @Override
    public Customer getById(Long id) {
        Query query = entityManager.createQuery("FROM Customer cus where cus.id=:id");
        query.setParameter("id", id);
        return (Customer) query.getResultList().toArray()[0];
    }

    @Override
    public void update(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }
}
