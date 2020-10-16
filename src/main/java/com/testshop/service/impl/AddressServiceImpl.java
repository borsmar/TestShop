package com.testshop.service.impl;

import com.testshop.dao.api.AddressDAO;
import com.testshop.dao.api.CategoryDAO;
import com.testshop.dao.api.UserDAO;
import com.testshop.dto.AddressDto;
import com.testshop.dto.CategoryDto;
import com.testshop.dto.GoodsDto;
import com.testshop.dto.OrdersDto;
import com.testshop.model.*;
import com.testshop.service.api.AddressService;
import com.testshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressDAO addressDAO;

    @Autowired
    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<AddressDto> getAll() {
        List<Address> addressesList = addressDAO.getAll();
        List<AddressDto> addressDtos = new ArrayList<>();
        for (Address address : addressesList) {
            AddressDto addressDto = convertAddressToDto(address);
            addressDtos.add(addressDto);
        }
        return addressDtos;
    }

    @Override
    @Transactional
    public AddressDto getById(Long id) {
        Address addr = addressDAO.getById(id);
        return convertAddressToDto(addr);
    }

    @Override
    @Transactional
    public void add(AddressDto addressDto, String id) {

        Address address = convertDtoToAddress(new Address(), addressDto);
        User user = userDAO.getById(Long.parseLong(id));

        user.getAddresses().add(address);
 //       address.getUsers().add(user);

        addressDAO.add(address);
    }

    @Override
    @Transactional
    public void update(AddressDto addressDto) throws JMSException {
        Address address = addressDAO.getById(addressDto.getId());
        addressDAO.update(convertDtoToAddress(address, addressDto));
    }

    @Override
    @Transactional
    public void deleteById(Long addressId) throws JMSException {
        addressDAO.delete(addressId);
    }

    public static AddressDto convertAddressToDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
 //       addressDto.setOrders(address.getOrders());
        addressDto.setState(address.getState());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setBuilding(address.getBuilding());
        addressDto.setApt(address.getApt());
        addressDto.setZipCode(address.getZipCode());
        //addressDto.setUsers(address.getUsers());

        return addressDto;
    }

    public static Address convertDtoToAddress(Address address, AddressDto addressDto) {

//        if(addressDto.getId() != null) {
//            address.setId(addressDto.getId());
//        }
        //address.setOrders(addressDto.getOrders());
        if(addressDto.getZipCode() != null && !addressDto.getZipCode().equals("")) {
            address.setZipCode(addressDto.getZipCode());
        }
        if(addressDto.getState() != null && !addressDto.getState().equals("")) {
            address.setState(addressDto.getState());
        }
        if(addressDto.getCity() != null && !addressDto.getCity().equals("")) {
            address.setCity(addressDto.getCity());
        }
        if(addressDto.getStreet() != null && !addressDto.getStreet().equals("")) {
            address.setStreet(addressDto.getStreet());
        }
        if(addressDto.getBuilding() != null && !addressDto.getBuilding().equals("")) {
            address.setBuilding(addressDto.getBuilding());
        }
        if(addressDto.getApt() != null && !addressDto.getApt().equals("")) {
            address.setApt(addressDto.getApt());
        }

       // address.setUsers(addressDto.getUsers());

        return address;
    }


}
