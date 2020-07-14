package com.testshop.dao.impl;

import com.testshop.dao.api.UserDAO;
import com.testshop.model.login.Login;
import com.testshop.model.login.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void register(User user) {
        entityManager.persist(user);
    }

    @Override
    public User validateUser(Login login) {
        return null;
    }
}
