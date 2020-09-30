package com.testshop.dao.impl;

import com.testshop.dao.api.RoleDAO;
import com.testshop.model.Role;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role add(Role role) {
        entityManager.persist(role);
        role = entityManager.find(Role.class, role.getId());
        entityManager.refresh(role);
        return role;
    }

    @Override
    public List<Role> getAll() {
        return entityManager.createQuery("from Role ").getResultList();
    }

    @Override
    public Role getById(Long id) {
        Query query = entityManager.createQuery("FROM Role cus where cus.id=:id");
        query.setParameter("id", id);
        return (Role) query.getResultList().toArray()[0];
    }

    @Override
    public void update(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }
}
