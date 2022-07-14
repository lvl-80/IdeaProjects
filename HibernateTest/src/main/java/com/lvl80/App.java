package com.lvl80;

import com.lvl80.services.MainService;

public class App {
    private static final MainService service = new MainService();
    public static void main(String[] args) {
        service.getTeamDao().findAll().forEach(System.out::println);
    }
}
