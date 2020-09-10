package com.testshop.dto;

import com.testshop.model.Goods;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class CategoryDto implements Serializable {
    private Long id;
    private String name;
    private List<GoodsDto> goodsDtos;

    public CategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
