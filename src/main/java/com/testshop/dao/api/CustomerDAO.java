package com.testshop.dao.api;

import com.testshop.model.Category;
import com.testshop.model.Customer;

import java.util.List;

public interface CustomerDAO {

    Customer add(Customer customer);

    List<Customer> getAll();

    Customer getById(Long id);

    void update(Customer customer);

    void delete(Long id);
}
