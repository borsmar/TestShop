package com.testshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
public class RolesDto implements Serializable {

    private Long id;
    private String name;
    private Set<UserDto> usersDtos;

}
