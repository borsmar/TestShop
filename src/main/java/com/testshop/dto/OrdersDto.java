package com.testshop.dto;

import com.testshop.model.Goods;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrdersDto {
    private Long id;
    private String paymentType;
    private String deliveryType;
    private String paymentStatus;
    private String orderStatus;
    private List<Goods> goods;
    private Long address_id;
    private Long customer_id;



}
