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
    private String firstName;
    private String surname;
    private String password;
    private String dateOfBirth;
    private String username;
  //  private List<OrdersDto> ordersDtos;
    private Set<AddressDto> addressesDtos;
    private Set<RolesDto> rolesDtos;
    private String email;

}
