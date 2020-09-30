package com.testshop.service.impl;

import com.testshop.dao.api.UserDAO;
import com.testshop.model.Role;
import com.testshop.model.User;
import com.testshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserService userService;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDAO.findByUsername(username);



   //     Set<Role> roles = user.getRoles();

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

    //    for (Role role: roles) {
   //         grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
    //   }

//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    }

