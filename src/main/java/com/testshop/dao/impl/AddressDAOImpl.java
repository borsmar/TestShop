package com.testshop.dao.impl;

import com.testshop.dao.api.AddressDAO;
import com.testshop.model.Address;
import com.testshop.model.Category;
import com.testshop.model.Orders;
import org.hibernate.QueryException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
       // entityManager.refresh(address);
        return address;
    }

    @Override
    public List<Address> getAll() {
        return entityManager.createQuery("from Address ").getResultList();
    }

    @Override
    public Address getAddress(Address address) throws NoResultException {



        Query query = entityManager.createQuery("SELECT addr FROM Address addr where addr.ZipCode=:ZipCode" +" AND addr.apt=:apt"+ " AND addr.building=:building"+" AND addr.city=:city"+" AND addr.state=:state"+" AND addr.street=:street");
        query.setParameter("ZipCode", address.getZipCode());
            query.setParameter("apt", address.getApt());
            query.setParameter("building", address.getBuilding());
            query.setParameter("city", address.getCity());
            query.setParameter("state", address.getState());
            query.setParameter("street", address.getStreet());


        return (Address)query.getSingleResult();
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
