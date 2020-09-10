package com.testshop.service.api;

import com.testshop.dto.AddressDto;
import com.testshop.dto.CustomerDto;
import com.testshop.model.Address;
import com.testshop.model.Customer;

import javax.jms.JMSException;
import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAll();

    CustomerDto getById(Long id);

    void add(Customer customer);

    void update(CustomerDto customer) throws JMSException;

    void deleteById(Long customerId) throws JMSException;
}
