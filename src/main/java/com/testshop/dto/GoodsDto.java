package com.testshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GoodsDto implements Serializable {
   private Long id;
   private String name;
   private int price;
   private String imageURL;
   private String description;
   private Long category_id;
   private String color;
   private int power;
   private String brand;
   private int weight;
   private String size;
   private int quantity;

    public GoodsDto(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
