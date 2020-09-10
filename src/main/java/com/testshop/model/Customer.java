package com.testshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
public class Customer {
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
    String Email;

    @ManyToMany
    List<Address> addresses;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    List<Orders> orders;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", SurName='" + SurName + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", Email='" + Email + '\'' +
                ", addresses=" + addresses +
                ", orders=" + orders +
                '}';
    }



}
