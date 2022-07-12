package com.lvl80.dao;

import com.lvl80.types.Player;

import java.util.List;

public class PlayerDao extends AbstractDao{
    public PlayerDao(){
        setClass_(Player.class);
    }

    public Player findById(long id){
        return getEntityManager().find(Player.class, id);
    }

    public List<Player> findAll(){
        return getEntityManager().createQuery("SELECT p FROM Player p join fetch p.team", Player.class).getResultList();
    }
}
