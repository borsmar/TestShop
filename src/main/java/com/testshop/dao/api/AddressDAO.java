package com.testshop.dao.api;

import com.testshop.model.Address;
import com.testshop.model.Category;

import java.util.List;

public interface AddressDAO {

    Address add(Address address);

    List<Address> getAll();

    Address getById(Long id);

    Address getAddress(Address address);

    void update(Address address);

    void delete(Long id);
}
