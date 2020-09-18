package com.testshop.dao.api;

import com.testshop.model.Goods;

import java.util.List;

public interface GoodsDAO {
    Goods add(Goods goods);

    List<Goods> getAll(Long id);

    Goods getById(Long id);

    void update(Goods goods);

    void delete(Long id);

    List<Goods> sortByPrice(Long id, Integer offset, String sort,Integer fromPrice, Integer toPrice, List<String> brands);

     int countGoods(Long id,Integer fromPrice, Integer toPrice);

     List<String> getBrandsByCategoryId(Long id);
}
