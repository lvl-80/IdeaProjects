package com.CoId;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        Horse horse1 = new Horse("Платва",0);
        Horse horse2 = new Horse("Кукуруза",1);
        Horse horse3 = new Horse("Еськов",2);
        Area area = new Area(new Horse[]{horse1,horse2,horse3});

        CyclicBarrier barrier = new CyclicBarrier(area.getSize()[0], new Runnable() {
            @Override
            public void run() {
                area.setFinished(true);
                System.out.println(area.getWinner().getName() + " победитель!");
            }
        });

        service.execute(new Redrawer(area));
        service.execute(new Dash(horse1,area,barrier));
        service.execute(new Dash(horse2,area,barrier));
        service.execute(new Dash(horse3,area,barrier));

        service.shutdown();
    }
}
