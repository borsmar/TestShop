package com.testshop.service.impl;

import com.testshop.dao.api.RoleDAO;
import com.testshop.dao.api.UserDAO;
import com.testshop.dto.RolesDto;
import com.testshop.dto.UserDto;
import com.testshop.model.Role;
import com.testshop.model.User;
import com.testshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<UserDto> getAll() {
        List<User> customersList = userDAO.getAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : customersList) {
            UserDto userDto = convertUserToDto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    @Transactional
    public UserDto getById(Long id) {
        User cus = userDAO.getById(id);
        return convertUserToDto(cus);
    }

    @Override
    @Transactional
    public void add(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // user.setRoles(new HashSet<>(roleDAO.getAll()));
        userDAO.add(user);

    }

    @Override
    @Transactional
    public void update(UserDto userDto) throws JMSException {
        User user = userDAO.getById(userDto.getId());
        userDAO.update(convertDtoToUser(user, userDto));
    }

    @Override
    @Transactional
    public void deleteById(Long userId) throws JMSException {
        userDAO.delete(userId);
    }

    @Override
    public UserDto findByUsername(String username) {
        return convertUserToDto(userDAO.findByUsername(username));
    }

    @Override
    public String GetCurrentUsername() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }


    public static UserDto convertUserToDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setPassword(user.getPassword());
        userDto.setSurname(user.getSurname());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());


        // userDto.setOrders(user.getOrders());
        //userDto.setAddresses(user.getAddresses());

        Set<RolesDto> rolesDtos = new HashSet<>();

        for (Role role : user.getRoles()) {
            rolesDtos.add(convertRolesToDto(role));
        }

        userDto.setRolesDtos(rolesDtos);

//        userDto.setRole_id(user.getRole().getId());

        return userDto;
    }

    public static RolesDto convertRolesToDto(Role role) {
        RolesDto rolesDto = new RolesDto();
        rolesDto.setId(role.getId());
        rolesDto.setName(role.getName());


        return rolesDto;

    }

    public Role convertDtoToRole(Role role, RolesDto rolesDto) {

        role.setId(rolesDto.getId());
        role.setName(rolesDto.getName());

        Set<User> userSet = new HashSet<>();
        for (UserDto userDto : rolesDto.getUsersDtos()) {
            userSet.add(convertDtoToUser(new User(), userDto));
        }

        role.setUsers(userSet);


        return role;
    }

    public User convertDtoToUser(User user, UserDto userDto) {
        user.setId(userDto.getId());


        user.setFirstName(userDto.getFirstName());
        user.setSurname(userDto.getSurname());
//        user.setPassword(userDto.getPassword());
//        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        //  user.setOrders(userDto.getOrders());
        // user.setAddresses(userDto.getAddresses());

        Set<Role> roleSet = new HashSet<>();
        for (RolesDto roleDto : userDto.getRolesDtos()) {
            roleSet.add(convertDtoToRole(new Role(), roleDto));
        }

        user.setRoles(roleSet);

//        orders.setAddress(ordersDto.getAddress_id());
//        orders.setCustomer_id(ordersDto.getCustomer().getId());

        return user;
    }

}
