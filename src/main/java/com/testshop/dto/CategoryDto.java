package com.testshop.dto;

import com.testshop.model.Goods;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private List<Goods> goods;

    public CategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
