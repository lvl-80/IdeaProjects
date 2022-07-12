package com.lvl80;

import com.lvl80.services.MainService;
import com.lvl80.types.Player;
import com.lvl80.types.Team;

import java.util.Scanner;

public class App {
    private static final MainService service = new MainService();
    private static boolean status = true;
    public static void main(String[] args) {
        System.out.println("\n\nДобро пожаловать на сервер");
        while (status) {
            System.out.println(
                    "Список операций:\n" +
                            "1) Вывести все записи игроков\n" +
                            "2) Вывести все записи команд\n" +
                            "3) Вывести конкретную запись игрока по id\n" +
                            "4) Вывести конкретную запись команды по id\n" +
                            "5) Добавить игрока\n" +
                            "6) Добавить команду\n" +
                            "7) Удалить игрока\n" +
                            "8) Удалить команду\n" +
                            "9) Обновить информацию об игроке\n" +
                            "10) Обновить информацию о команде\n" +
                            "11) Выход"
            );
            int choice = new Scanner(System.in).nextInt();
            checkValue(choice);
        }
    }

    public static void checkValue(int choice){
        int id;
        String[] choices = null;
        Player player = null;
        Team team = null;
        switch (choice){
            case 1:
                service.getPlayerDao().findAll().forEach(System.out::println);
                break;
            case 2:
                service.getTeamDao().findAll().forEach(System.out::println);
                break;
            case 3:
                System.out.println("Введите id записи:");
                id = new Scanner(System.in).nextInt();
                System.out.println(service.getPlayerDao().findById(id));
                break;
            case 4:
                System.out.println("Введите id записи:");
                id = new Scanner(System.in).nextInt();
                System.out.println(service.getTeamDao().findById(id));
                break;
            case 5:
                System.out.println("Введите данные игрока (Имя, Заработок, id команды):");
                choices = new Scanner(System.in).nextLine().split(", ");
                player = new Player(
                        choices[0],
                        Integer.parseInt(choices[1]),
                        service.getTeamDao().findByIdWithGraph(Integer.parseInt(choices[2]))
                );
                service.getPlayerDao().save(player);
                System.out.println(player + " успешно сохранён");
                break;
            case 6:
                System.out.println("Введите данные команды (Название, Капитал):");
                choices = new Scanner(System.in).nextLine().split(", ");
                team = new Team(choices[0], Integer.parseInt(choices[1]));
                service.getPlayerDao().save(team);
                System.out.println(team + " успешно сохранена");
                break;
            case 7:
                System.out.println("Введите id записи:");
                id = new Scanner(System.in).nextInt();
                service.getPlayerDao().deleteById(id);
                break;
            case 8:
                System.out.println("Введите id записи:");
                id = new Scanner(System.in).nextInt();
                service.getTeamDao().deleteById(id);
                break;
            case 9:
                System.out.println("Введите данные игрока для изменения (Имя, Заработок, id команды):");
                choices = new Scanner(System.in).nextLine().split(", ");
                player = new Player(
                        choices[0],
                        Integer.parseInt(choices[1]),
                        service.getTeamDao().findByIdWithGraph(Integer.parseInt(choices[2]))
                );
                service.getPlayerDao().update(player);
                System.out.println(player + " успешно обновлён");
                break;
            case 10:
                System.out.println("Введите данные команды для изменения (Название, Капитал):");
                choices = new Scanner(System.in).nextLine().split(", ");
                team = new Team(choices[0], Integer.parseInt(choices[1]));
                service.getPlayerDao().update(team);
                System.out.println(team + " успешно обновлена");
                break;
            case 11:
                status = false;
                break;
        }
    }
}
