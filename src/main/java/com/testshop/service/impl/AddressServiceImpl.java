package com.testshop.service.impl;

import com.testshop.dao.api.AddressDAO;
import com.testshop.dao.api.CategoryDAO;
import com.testshop.dto.AddressDto;
import com.testshop.dto.CategoryDto;
import com.testshop.dto.GoodsDto;
import com.testshop.dto.OrdersDto;
import com.testshop.model.Address;
import com.testshop.model.Category;
import com.testshop.model.Goods;
import com.testshop.model.Orders;
import com.testshop.service.api.AddressService;
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
    public void add(Address address) {
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
        addressDto.setOrders(address.getOrders());
        addressDto.setState(address.getState());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setBuilding(address.getBuilding());
        addressDto.setApt(address.getApt());
        addressDto.setCustomers(address.getCustomers());

        return addressDto;
    }

    public Address convertDtoToAddress(Address address, AddressDto addressDto) {
        address.setId(addressDto.getId());
        address.setOrders(addressDto.getOrders());
        address.setZipCode(addressDto.getZipCode());
        address.setState(addressDto.getState());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setBuilding(addressDto.getBuilding());
        address.setApt(addressDto.getApt());
        address.setCustomers(addressDto.getCustomers());


//        orders.setAddress(ordersDto.getAddress_id());
//        orders.setCustomer_id(ordersDto.getCustomer().getId());

        return address;
    }


}
