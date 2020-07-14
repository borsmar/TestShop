package com.testshop.dao.api;

import com.testshop.model.login.Login;
import com.testshop.model.login.User;

public interface UserDAO {
    void register(User user);
    User validateUser(Login login);
}
