package com.lvl80.services;

import com.lvl80.dao.PlayerDao;
import com.lvl80.dao.TeamDao;

public class MainService {
    private final TeamDao teamDao = new TeamDao();
    private final PlayerDao playerDao = new PlayerDao();

    public TeamDao getTeamDao() {
        return teamDao;
    }

    public PlayerDao getPlayerDao() {
        return playerDao;
    }
}
