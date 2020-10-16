package com.testshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"state", "city", "ZipCode", "street", "building", "apt"})
})

@NoArgsConstructor
public class Address {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Orders> orders;


    @ManyToMany(mappedBy = "addresses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Set<User> users;

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
       //         ", orders=" + orders +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", apt='" + apt + '\'' +
                '}';
    }
}
