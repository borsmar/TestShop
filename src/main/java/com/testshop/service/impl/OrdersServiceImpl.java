package com.testshop.service.impl;

import com.testshop.dao.api.GoodsDAO;
import com.testshop.dao.api.OrdersDAO;
import com.testshop.dto.CategoryDto;
import com.testshop.dto.OrdersDto;
import com.testshop.model.Category;
import com.testshop.model.Orders;
import com.testshop.service.api.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersDAO ordersDAO;


    @Autowired
    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }


    @Override
    @Transactional
    public List<OrdersDto> getAll() {
        List<Orders> ordersList = ordersDAO.getAll();
        List<OrdersDto> ordersDtos = new ArrayList<>();
        for (Orders orders : ordersList) {
            OrdersDto ordersDto = convertOrdersToDto(orders);
            ordersDtos.add(ordersDto);
        }
        return ordersDtos;
    }

    @Override
    @Transactional
    public OrdersDto getById(Long id) {
        Orders order = ordersDAO.getById(id);
        return convertOrdersToDto(order);
    }

    @Override
    @Transactional
    public void add(Orders order) {
        ordersDAO.add(order);
    }

    @Override
    @Transactional
    public void update(OrdersDto ordersDto) throws JMSException {
        Orders orders = ordersDAO.getById(ordersDto.getId());
        ordersDAO.update(convertDtoToOrders(orders, ordersDto));
    }

    @Override
    @Transactional
    public void deleteById(Long orderId) throws JMSException {
        ordersDAO.delete(orderId);
    }

    public OrdersDto convertOrdersToDto(Orders orders) {
        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setId(orders.getId());
        ordersDto.setPaymentType(orders.getPaymentType());
        ordersDto.setDeliveryType(orders.getDeliveryType());
        ordersDto.setOrderStatus(orders.getOrderStatus());
        ordersDto.setGoods(orders.getGoods());
        ordersDto.setAddress_id(orders.getAddress().getId());
      //  ordersDto.setCustomer_id(orders.getUser().getId());

        return ordersDto;
    }

    public Orders convertDtoToOrders(Orders orders, OrdersDto ordersDto){
        orders.setId(ordersDto.getId());
        orders.setPaymentType(ordersDto.getPaymentType());
        orders.setDeliveryType(ordersDto.getDeliveryType());
        orders.setOrderStatus(ordersDto.getOrderStatus());
        orders.setGoods(ordersDto.getGoods());
//        orders.setAddress(ordersDto.getAddress_id());
//        orders.setCustomer_id(ordersDto.getCustomer().getId());

        return orders;
    }

}
