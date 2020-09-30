package com.testshop.dao.api;

import com.testshop.model.Role;

import java.util.List;

public interface RoleDAO {
    Role add(Role role);

    List<Role> getAll();

    Role getById(Long id);

    void update(Role role);

    void delete(Long id);
}
