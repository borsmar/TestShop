package com.testshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String FirstName;

    @Column
    String SurName;

    @Column
    String DateOfBirth;

    @Column
    String username;

    @Column
    String password;

    @Column
    String Email;


   // @ManyToMany(fetch = FetchType.LAZY)
   // @JsonIgnore List<Address> addresses;

  //  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  //  List<Orders> orders;



//    @ManyToMany(fetch = FetchType.LAZY)
//    Set<Role> roles;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", SurName='" + SurName + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
              //  ", addresses=" + addresses +
             //   ", orders=" + orders +
                ", role=" + role +
                '}';
    }


}
