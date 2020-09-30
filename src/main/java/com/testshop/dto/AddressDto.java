package com.testshop.dto;

import com.testshop.model.Goods;
import com.testshop.model.Orders;
import com.testshop.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class AddressDto implements Serializable {
    private Long id;
    private List<Orders> orders;
    private List<User> users;
    private String state;
    private String city;
    private String ZipCode;
    private String street;
    private String building;
    private String apt;

}
