package com.testshop.service.impl;

import com.testshop.dao.api.AddressDAO;
import com.testshop.dao.api.RoleDAO;
import com.testshop.dao.api.UserDAO;
import com.testshop.dto.AddressDto;
import com.testshop.dto.RolesDto;
import com.testshop.dto.UserDto;
import com.testshop.model.Address;
import com.testshop.model.Role;
import com.testshop.model.User;
import com.testshop.service.api.UserService;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.testshop.service.impl.AddressServiceImpl.convertAddressToDto;
import static com.testshop.service.impl.AddressServiceImpl.convertDtoToAddress;

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

    @Autowired
    private AddressDAO addressDAO;

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

        Role role = roleDAO.getById(Long.parseLong("2"));


        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));


        Set<Role> roles = new HashSet<>();
        roles.add(role);

        user.setRoles(roles);


        role.getUsers().add(user);

        userDAO.add(user);


    }

    @Override
    @Transactional
    public void deleteAddress(UserDto userDto, String id)  {

        Address address = addressDAO.getById(Long.parseLong(id));
        User user = userDAO.getById(userDto.getId());
        user.getAddresses().remove(address);
        address.getUsers().remove(user);

        userDAO.update(user);

    }

    @Override
    @Transactional
    public void updateAddress(AddressDto addressDto,String userId, String id) {

       Address address = addressDAO.getById(Long.parseLong(id));


       User user = userDAO.getById(Long.parseLong(userId));

       Address address2 = new Address();
        address2.setZipCode(address.getZipCode());
        address2.setApt(address.getApt());
        address2.setBuilding(address.getBuilding());
        address2.setStreet(address.getStreet());
        address2.setCity(address.getCity());
        address2.setState(address.getState());


        Address addressChanged = convertDtoToAddress(address2, addressDto);

user.getAddresses().remove(address);
address.getUsers().remove(user);

try {
    Address addressCheck = addressDAO.getAddress(addressChanged);
    user.getAddresses().add(addressCheck);
    addressCheck.getUsers().add(user);
    userDAO.update(user);
}
catch (NoResultException e){
    user.getAddresses().add(addressChanged);
    addressDAO.add(addressChanged);

}


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

        Set<AddressDto> addressesDtosSet = new HashSet<>();
        for (Address address : user.getAddresses()) {
            addressesDtosSet.add(convertAddressToDto(address));
        }

        userDto.setAddressesDtos(addressesDtosSet);

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
//        user.setId(userDto.getId());

        if (!(userDto.getFirstName() == null)) {
            user.setFirstName(userDto.getFirstName());
        }
        if (!(userDto.getSurname() == null)) {
            user.setSurname(userDto.getSurname());
        }
//        user.setPassword(userDto.getPassword());
//        user.setDateOfBirth(userDto.getDateOfBirth());
        if (!(userDto.getUsername() == null)) {
            user.setUsername(userDto.getUsername());
        }

        if (!(userDto.getEmail() == null)) {
            user.setEmail(userDto.getEmail());
        }
        //  user.setOrders(userDto.getOrders());


//       Set<Address> addressSet = new HashSet<>();
//        for (AddressDto addressDto : userDto.getAddressesDtos()) {
//         //  Address address = new Address();
//        //    address.getUsers().add(user);
//            addressSet.add(convertDtoToAddress(new Address(), addressDto));
//        }
//    if(!addressSet.isEmpty()) {
//     user.setAddresses(addressSet);
//    }

//        Set<Role> roleSet = new HashSet<>();
//        for (RolesDto roleDto : userDto.getRolesDtos()) {
//            roleSet.add(convertDtoToRole(new Role(), roleDto));
//        }
//
//        user.setRoles(roleSet);

//        orders.setAddress(ordersDto.getAddress_id());
//        orders.setCustomer_id(ordersDto.getCustomer().getId());

        return user;
    }

    @Override
    @Transactional
    public void changeUserPassword(UserDto userDto, String password, String currentPassword) {


        User user = userDAO.getById(userDto.getId());


        if (bCryptPasswordEncoder.matches(currentPassword, user.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(password));
            userDAO.update(user);
        }
    }

}
