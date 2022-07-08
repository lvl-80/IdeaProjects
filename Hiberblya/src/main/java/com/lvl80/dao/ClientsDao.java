package com.lvl80.dao;

import com.lvl80.model.Clients;

public class ClientsDao extends AbstractDao<Clients> {
    public ClientsDao(){
        settClass(Clients.class);
    }

}
