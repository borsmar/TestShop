package com.testshop.service.impl;

import com.testshop.dao.api.UserDAO;
import com.testshop.model.login.User;
import com.testshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public void add(User user) {
        userDAO.register(user);
    }
}
