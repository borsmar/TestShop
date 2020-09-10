package com.testshop.service.api;

import com.testshop.dto.CategoryDto;
import com.testshop.dto.OrdersDto;
import com.testshop.model.Category;
import com.testshop.model.Orders;

import javax.jms.JMSException;
import java.util.List;

public interface OrdersService {
    List<OrdersDto> getAll();

    OrdersDto getById(Long id);

    void add(Orders order);

    void update(OrdersDto order) throws JMSException;

    void deleteById(Long orderId) throws JMSException;
}
