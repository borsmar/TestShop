package com.testshop.dao.impl;

import com.testshop.dao.api.AddressDAO;
import com.testshop.model.Address;
import com.testshop.model.Category;
import com.testshop.model.Orders;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class AddressDAOImpl implements AddressDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address add(Address address) {
        entityManager.persist(address);
        address = entityManager.find(Address.class, address.getId());
        entityManager.refresh(address);
        return address;
    }

    @Override
    public List<Address> getAll() {
        return entityManager.createQuery("from Address ").getResultList();
    }

    @Override
    public Address getById(Long id) {
        Query query = entityManager.createQuery("FROM Address addr where addr.id=:id");
        query.setParameter("id", id);
        return (Address) query.getResultList().toArray()[0];
    }

    @Override
    public void update(Address address) {
        entityManager.persist(address);

    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }
}
