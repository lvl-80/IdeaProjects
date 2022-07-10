package com.lvl80.dao;

import com.lvl80.utils.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

public class AbstractDao <T> {
    private Class<T> class_;

    public void setClass_(Class<T> class_) {
        this.class_ = class_;
    }

    private final EntityManager entityManager = HibernateFactoryUtil.getEntityManagerFactory().createEntityManager();

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void update(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public void deleteById(long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }

    public T findById(long id){
        return entityManager.find(class_, id);
    }

    public List<T> findAll(){
        return entityManager.createQuery("SELECT e FROM " + class_.getSimpleName() + " e", class_).getResultList();
    }

    public T findById(long id, Map<String, Object> prop){
        return entityManager.find(class_,id,prop);
    }
}
