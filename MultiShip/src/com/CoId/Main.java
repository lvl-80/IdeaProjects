package com.CoId;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Tunnel tunnel = new Tunnel();
        ShipGenerator shipGenerator = new ShipGenerator(tunnel);

        Loader loader1 = new Loader(tunnel, ShipType.Bread);
        Loader loader2 = new Loader(tunnel, ShipType.Clothes);
        Loader loader3 = new Loader(tunnel, ShipType.Bananas);

        service.execute(shipGenerator);
        service.execute(loader1);
        service.execute(loader2);
        service.execute(loader3);

        service.shutdown();
    }
}

