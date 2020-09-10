package com.testshop.dao.api;

import com.testshop.model.Goods;
import com.testshop.model.Orders;

import java.util.List;

public interface OrdersDAO {

    Orders add(Orders order);

    List<Orders> getAll();

    Orders getById(Long id);

    void update(Orders order);

    void delete(Long id);

}
