package com.lvl80.dao;

import com.lvl80.types.Player;

public class PlayerDao extends AbstractDao{
    public PlayerDao(){
        setClass_(Player.class);
    }
}
