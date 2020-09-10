package com.testshop.dto;

import com.testshop.model.Customer;
import com.testshop.model.Goods;
import com.testshop.model.Orders;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@NoArgsConstructor
public class AddressDto {
    private Long id;
    private List<Orders> orders;
    private List<Customer> customers;
    private String state;
    private String city;
    private String ZipCode;
    private String street;
    private String building;
    private String apt;

}
