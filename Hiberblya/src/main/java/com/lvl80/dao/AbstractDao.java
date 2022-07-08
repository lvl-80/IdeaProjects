package com.lvl80.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class AbstractDao<T extends Serializable> {
    private Class<T> tClass;
    private final EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("com.lvl80");

    public final EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public void settClass(Class<T> tClass) {
        this.tClass = tClass;
    }

    public void save(T entity){
        getEntityManager().persist(entity);
    }

    public void update(T entity){
        getEntityManager().merge(entity);
    }

    public void delete(T entity){
        getEntityManager().remove(entity);
    }

    public void deleteById(long id){
        getEntityManager().remove(find(id));
    }

    public T find(long id){
        return getEntityManager().find(tClass,id);
    }

    public T find(long id, Map<String, Object> prop){
        return getEntityManager().find(tClass,id,prop);
    }

    public List<T> findAll(){
        return getEntityManager().createQuery("select c from " + tClass.getName() + " c", tClass).getResultList();
    }
}
