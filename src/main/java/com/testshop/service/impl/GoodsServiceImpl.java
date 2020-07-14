package com.testshop.service.impl;

import com.testshop.dao.api.CategoryDAO;
import com.testshop.dao.api.GoodsDAO;
import com.testshop.dto.GoodsDto;
import com.testshop.model.Category;
import com.testshop.model.Goods;
import com.testshop.service.api.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {

    private GoodsDAO goodsDAO;
    private CategoryDAO categoryDAO;

    @Autowired
    public void setGoodsDAO(GoodsDAO goodsDAO) {
        this.goodsDAO = goodsDAO;
    }

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    @Transactional
    public List<GoodsDto> getAll(Long id) {
        List<Goods> goodsList = goodsDAO.getAll(id);
        List<GoodsDto> goodsDtos = new ArrayList<>();
        for(Goods goods : goodsList){
            GoodsDto goodsDto = convertGoodsToDto(goods);
            goodsDtos.add(goodsDto);
        }
        return goodsDtos;
    }

    @Override
    @Transactional
    public GoodsDto getById(Long id) {
        Goods goo = goodsDAO.getById(id);
        return convertGoodsToDto(goo);
    }

    @Override
    @Transactional
    public boolean add(GoodsDto goodsDto) {
        Category category = categoryDAO.getById(goodsDto.getCategory_id());
        Goods goods = convertDtoToGoods(new Goods(), goodsDto);
        goods.setCategory(categoryDAO.getById(goodsDto.getCategory_id()));
        Goods g = goodsDAO.add(goods);

        return true;
    }

    @Override
    @Transactional
    public void update(GoodsDto goodsDto) throws JMSException {
        Goods goods = goodsDAO.getById(goodsDto.getId());
        goodsDAO.update(convertDtoToGoods(goods, goodsDto));
    }

    @Override
    @Transactional
    public void deleteById(Long goodsId) throws JMSException {
        goodsDAO.delete(goodsId);
    }

    @Override
    @Transactional
    public Long getCategoryId(Long gooId) {
        Goods goods = goodsDAO.getById(gooId);
        Category category = goods.getCategory();
        return category.getId();
    }

    public static GoodsDto convertGoodsToDto(Goods goods){
        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setId(goods.getId());
        goodsDto.setName(goods.getName());
        goodsDto.setPrice(goods.getPrice());
        goodsDto.setCategory_id(goods.getCategory().getId());
        goodsDto.setColor(goods.getColor());
        goodsDto.setPower(goods.getPower());
        goodsDto.setBrand(goods.getBrand());
        goodsDto.setSize(goods.getSize());
        goodsDto.setWeight(goods.getWeight());
        goodsDto.setQuantity(goods.getQuantity());

        return goodsDto;
    }

    public static Goods convertDtoToGoods(Goods goods, GoodsDto goodsDto){
        goods.setName(goodsDto.getName());
        goods.setPrice(goodsDto.getPrice());
        goods.setColor(goodsDto.getColor());
        goods.setPower(goodsDto.getPower());
        goods.setBrand(goodsDto.getBrand());
        goods.setSize(goodsDto.getSize());
        goods.setWeight(goodsDto.getWeight());
        goods.setQuantity(goodsDto.getQuantity());
        goods.setId(goodsDto.getId());

        return goods;
    }

}
