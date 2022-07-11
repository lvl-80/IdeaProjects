package com.lvl80;

import com.lvl80.dao.TeamDao;
import com.lvl80.types.Player;
import com.lvl80.types.Team;

public class App {
    public static void main(String[] args) {
        TeamDao teamDao = new TeamDao();
        Team team1 = new Team("Juventus", 2800);
        Team team2 = new Team("Dinamo", 1800);
        Player player1 = new Player("Ronaldo", 700, team1);
        Player player2 = new Player("Messi", 690,team1);
        team1.getPlayers().add(player1);
        team1.getPlayers().add(player2);
        teamDao.save(team1);
        teamDao.save(team2);
    }
}
