package com.testshop.dao.impl;

import com.testshop.dao.api.UserDAO;
import com.testshop.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public User add(User user) {
        entityManager.persist(user);
        user = entityManager.find(User.class, user.getId());
        entityManager.refresh(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User ").getResultList();
    }

    @Override
    public User getById(Long id) {
        Query query = entityManager.createQuery("FROM User cus where cus.id=:id");
        query.setParameter("id", id);
        return (User) query.getResultList().toArray()[0];
    }

    @Override
    public void update(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public User findByUsername(String username){
        Query query = entityManager.createQuery("FROM User cus where cus.username=:username");
        query.setParameter("username", username);
        return (User) query.getResultList().toArray()[0];
    }
}
