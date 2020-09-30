package com.testshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Orders> orders;


    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore List<User> users;

    @Column
    String state;

    @Column
    String city;

    @Column
    String ZipCode;

    @Column
    String street;

    @Column
    String building;

    @Column
    String apt;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", orders=" + orders +
                ", users=" + users +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", apt='" + apt + '\'' +
                '}';
    }
}
