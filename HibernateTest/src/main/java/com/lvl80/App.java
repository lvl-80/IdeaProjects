package com.lvl80;

import com.lvl80.dao.TeamDao;

public class App {
    public static void main(String[] args) {
        TeamDao teamDao = new TeamDao();
        teamDao.findAll().forEach(System.out::println);
    }
}
