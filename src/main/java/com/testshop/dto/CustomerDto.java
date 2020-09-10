package com.testshop.dto;

import com.testshop.model.Address;
import com.testshop.model.Orders;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String FirstName;
    private String SurName;
    private String DateOfBirth;
    private String Email;
    private List<Orders> orders;
    private List<Address> addresses;

}
