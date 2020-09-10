package com.testshop.service.impl;

import com.testshop.dao.api.AddressDAO;
import com.testshop.dao.api.CustomerDAO;
import com.testshop.dto.AddressDto;
import com.testshop.dto.CustomerDto;
import com.testshop.dto.OrdersDto;
import com.testshop.model.Address;
import com.testshop.model.Customer;
import com.testshop.model.Orders;
import com.testshop.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<CustomerDto> getAll() {
        List<Customer> customersList = customerDAO.getAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customersList) {
            CustomerDto customerDto = convertCustomerToDto(customer);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    @Override
    @Transactional
    public CustomerDto getById(Long id) {
        Customer cus = customerDAO.getById(id);
        return convertCustomerToDto(cus);
    }

    @Override
    @Transactional
    public void add(Customer customer) {
        customerDAO.add(customer);
    }

    @Override
    @Transactional
    public void update(CustomerDto customerDto) throws JMSException {
        Customer customer = customerDAO.getById(customerDto.getId());
        customerDAO.update(convertDtoToCustomer(customer, customerDto));
    }

    @Override
    @Transactional
    public void deleteById(Long customerId) throws JMSException {
        customerDAO.delete(customerId);
    }

    public static CustomerDto convertCustomerToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setSurName(customer.getSurName());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        customerDto.setEmail(customer.getEmail());
        customerDto.setOrders(customer.getOrders());
        customerDto.setAddresses(customer.getAddresses());


        return customerDto;
    }

    public Customer convertDtoToCustomer(Customer customer, CustomerDto customerDto) {
        customer.setId(customerDto.getId());


        customer.setFirstName(customerDto.getFirstName());
        customer.setSurName(customerDto.getSurName());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setEmail(customerDto.getEmail());
        customer.setOrders(customerDto.getOrders());
        customer.setAddresses(customerDto.getAddresses());


//        orders.setAddress(ordersDto.getAddress_id());
//        orders.setCustomer_id(ordersDto.getCustomer().getId());

        return customer;
    }

}
