package com.testshop.dao.api;

import com.testshop.model.Category;
import com.testshop.model.User;

import java.util.List;

public interface UserDAO {

    User add(User user);

    List<User> getAll();

    User getById(Long id);

    void update(User user);

    void delete(Long id);

    User findByUsername(String username);
}
