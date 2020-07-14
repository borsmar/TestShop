package com.testshop.dao.api;

import com.testshop.model.Goods;

import java.util.List;

public interface GoodsDAO {
    Goods add(Goods goods);
    List<Goods> getAll(Long id);
    Goods getById(Long id);
    void update(Goods goods);
    void delete(Long id);
}
