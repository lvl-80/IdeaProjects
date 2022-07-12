package com.lvl80;

import com.lvl80.services.MainService;
import com.lvl80.types.Player;

public class App {
    public static void main(String[] args) {
        MainService service = new MainService();
        Player p = new Player("Mikita",100, service.getTeamDao().findById(3));
        service.getPlayerDao().save(p);
        System.out.println("-----");
        service.getPlayerDao().findAll().forEach(System.out::println);
    }
}
