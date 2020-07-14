package com.testshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDao {
    private static final EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("TestPersistence");
    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }
}
