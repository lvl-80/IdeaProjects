package com.lvl80.dao;

import com.lvl80.types.Team;

import java.util.List;

public class TeamDao extends AbstractDao{

    public TeamDao() {
        setClass_(Team.class);
    }

    public Team findById(long id){
        return getEntityManager().find(Team.class, id);
    }

    public List<Team> findAll(){
        return getEntityManager().createQuery("SELECT t FROM Team t", Team.class).getResultList();
    }
}
