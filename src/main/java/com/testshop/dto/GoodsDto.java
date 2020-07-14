package com.testshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsDto {
   private Long id;
   private String name;
   private int price;
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
