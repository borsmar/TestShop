package com.testshop.service.api;

import com.testshop.dto.UserDto;
import com.testshop.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.jms.JMSException;
import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getById(Long id);

    void add(User user);

    void update(UserDto user) throws JMSException;

    void deleteById(Long customerId) throws JMSException;

    UserDto findByUsername(String username);

    String GetCurrentUsername();


}
