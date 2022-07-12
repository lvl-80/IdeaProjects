package com.lvl80.dao;

import com.lvl80.types.Team;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamDao extends AbstractDao{

    public TeamDao() {
        setClass_(Team.class);
    }

    public Team findById(long id){
        return getEntityManager().find(Team.class, id);
    }

    public Team findByIdWithGraph(long id){
        EntityGraph graph = getEntityManager().getEntityGraph("Team_graph");
        Map prop = new HashMap();
        prop.put("javax.persistence.fetchgraph", graph);
        return getEntityManager().find(Team.class, id, prop);
    }

    public List<Team> findAll(){
        return getEntityManager().createQuery("SELECT t FROM Team t", Team.class).getResultList();
    }
}
