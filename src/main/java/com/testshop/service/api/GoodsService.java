package com.testshop.service.api;

import com.testshop.dto.GoodsDto;

import javax.jms.JMSException;
import java.util.List;

public interface GoodsService {

    List<GoodsDto> getAll(Long id);

    List<GoodsDto> sortByPrice(Long id, Integer offset, String sort);

    GoodsDto getById(Long id);

    boolean add(GoodsDto goodsDto);

    void update(GoodsDto goods) throws JMSException;

    void deleteById(Long goodsId) throws JMSException;

    Long getCategoryId(Long gooId);

    int countPagesByCategory(Long id);


}
