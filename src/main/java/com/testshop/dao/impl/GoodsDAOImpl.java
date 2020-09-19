package com.testshop.dao.impl;

import com.testshop.dao.api.GoodsDAO;
import com.testshop.model.Category;
import com.testshop.model.Goods;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoodsDAOImpl implements GoodsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Goods add(Goods goods) {
        entityManager.persist(goods);
        goods = entityManager.find(Goods.class, goods.getId());
        entityManager.refresh(goods);
        return goods;
    }

    @Override
    public List<Goods> getAll(Long id) {
        Query query = entityManager.createQuery("FROM Category as g LEFT join fetch g.goods where g.id=:id");
        query.setParameter("id", id);
        Category category = (Category) query.getResultList().toArray()[0];
        return new ArrayList<Goods>(category.getGoods());
    }

    @Override
    public List<Goods> sortByPrice(Long id, Integer offset, String sort,Integer fromPrice, Integer toPrice, List<String> brands) {


        List<Goods> sortedGoodsList;

        String ord;
        switch (sort) {
            case "price_asc":
                ord = "price";
                break;
            case "price_desc":
                ord = "price DESC";
                break;
            case "newer_first":
                ord = "id DESC";
                break;
            default:
                ord = "price";
                break;
        }

        if(fromPrice == null){
            fromPrice = 0;
        }

        if (toPrice == null || toPrice == 0){
            Query query = entityManager.createQuery("SELECT c from Goods c where c.category.id =: id AND" + " c.price >=: fromPrice AND c.brand IN (:brands)  ORDER BY " + ord);
                query.setParameter("fromPrice", fromPrice);
                query.setParameter("brands", brands);
                query.setParameter("id", id);

            query.setFirstResult(offset);

            sortedGoodsList = query.getResultList();
        }
        else {
            Query query = entityManager.createQuery("SELECT c from Goods c where c.category.id =: id AND" + " c.price >=: fromPrice AND c.price <=: toPrice AND c.brand IN (:brands) ORDER BY " + ord);
                query.setParameter("fromPrice", fromPrice);
                query.setParameter("brands", brands);
                query.setParameter("toPrice", toPrice);
                query.setParameter("id", id);

            query.setFirstResult(offset);

            sortedGoodsList = query.getResultList();
        }




            if (sortedGoodsList.size() > 8) {
                sortedGoodsList = sortedGoodsList.subList(0, 8);
            }

            return sortedGoodsList;



    }

    @Override
    public int countGoods(Long id, Integer fromPrice, Integer toPrice, List<String> brands ) {

        if(fromPrice == null){
            fromPrice = 0;
        }
            int count;

        if (toPrice == null || toPrice == 0){
            Query query = entityManager.createQuery("SELECT c from Goods c where c.category.id =: id AND" + " c.price >=: fromPrice AND c.brand IN (:brands)");
            query.setParameter("fromPrice", fromPrice);
            query.setParameter("brands", brands);
            query.setParameter("id", id);

            count = query.getResultList().size();
        }
        else {
            Query query = entityManager.createQuery("SELECT c from Goods c where c.category.id =: id AND" + " c.price >=: fromPrice  AND c.price <=: toPrice AND c.brand IN (:brands)");
            query.setParameter("fromPrice", fromPrice);
            query.setParameter("brands", brands);
            query.setParameter("toPrice", toPrice);
            query.setParameter("id", id);

            count = query.getResultList().size();
        }

        return count;
    }

    @Override
    public List<String> getBrandsByCategoryId(Long id) {
        Query query = entityManager.createQuery("SELECT DISTINCT c.brand FROM Goods c where c.category.id =: id");
        query.setParameter("id", id);
        return  query.getResultList();
    }


    @Override
    public Goods getById(Long id) {
        Query query = entityManager.createQuery("FROM Goods goo where goo.id=:id");
        query.setParameter("id", id);
        return (Goods) query.getResultList().toArray()[0];
    }

    @Override
    public void update(Goods goods) {
        entityManager.persist(goods);

    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }
}
