package com.lvl80.dao;

import com.lvl80.utils.HibernateFactoryUtil;

import javax.persistence.EntityManager;

public abstract class AbstractDao <T> {
    private Class<T> class_;

    public void setClass_(Class<T> class_) {
        this.class_ = class_;
    }

    private final EntityManager entityManager = HibernateFactoryUtil.getEntityManagerFactory().createEntityManager();

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(long id) {
        entityManager.remove(entityManager.find(class_, id));
    }
}
