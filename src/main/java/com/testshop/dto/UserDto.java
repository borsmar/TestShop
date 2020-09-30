package com.testshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.testshop.model.Address;
import com.testshop.model.Orders;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String FirstName;
    private String SurName;
    private String Password;
    private String DateOfBirth;
    private String username;
  //  private List<OrdersDto> ordersDtos;
   // private List<Address> addresses;
    private Long role_id;
    private String email;

}
