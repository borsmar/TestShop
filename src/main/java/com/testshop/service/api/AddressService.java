package com.testshop.service.api;

import com.testshop.dto.AddressDto;
import com.testshop.dto.CategoryDto;
import com.testshop.model.Address;
import com.testshop.model.Category;

import javax.jms.JMSException;
import java.util.List;

public interface AddressService {
    List<AddressDto> getAll();

    AddressDto getById(Long id);

    void add(Address address);

    void update(AddressDto address) throws JMSException;

    void deleteById(Long addressId) throws JMSException;
}
