package com.lvl80.utils;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateFactoryUtil {
    private static final EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("com.lvl80");

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

    public static SessionFactory getSessionFactory(){
        return entityManagerFactory.unwrap(SessionFactory.class);
    }
}
