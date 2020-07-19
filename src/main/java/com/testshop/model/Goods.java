package com.testshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table
@NoArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String name;

    @Column
    int price;

    @Column
    String imageURL;

    @Column
    String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    String color;

    @Column
    int power;

    @Column
    String brand;

    @Column
    int weight;

    @Column
    String size;

    @Column
    int quantity;

    public Goods(Long id, Category category, String name, int price ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", color='" + color + '\'' +
                ", power=" + power +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
