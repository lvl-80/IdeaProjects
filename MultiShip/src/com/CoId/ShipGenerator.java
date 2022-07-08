package com.CoId;

import java.util.Random;

public class ShipGenerator implements Runnable{
    private final Tunnel tunnel;
    ShipGenerator(Tunnel tunnel){
        this.tunnel = tunnel;
    }
    public void run(){
        while (true){
            tunnel.add(new Ship(
                    Ship.getTypeArray()[new Random().nextInt(3)],
                    new Random().nextInt(10) + 1));
        }
    }
}