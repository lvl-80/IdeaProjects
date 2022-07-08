package com.lvl80.dao;

import com.lvl80.model.Books;

import java.util.List;

public class BooksDao extends AbstractDao<Books>{
    public BooksDao(){
        settClass(Books.class);
    }

    @Override
    public List<Books> findAll(){
        return getEntityManager().createQuery("select b from Books b join fetch b.client", Books.class).getResultList();
    }
}
