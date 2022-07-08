package com.CoId;


public class Loader implements Runnable{
    private final Tunnel tunnel;
    private final ShipType type;
    Loader(Tunnel tunnel, ShipType type){
        this.tunnel = tunnel;
        this.type = type;
    }
    public void run(){
        try {
            while (true){
                Ship _Ship = tunnel.get(type);
                if (_Ship != null) {
                    System.out.println("Началась загрузка " + _Ship.getType() + " " + _Ship.getCapacity());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Кончилась загрузка " + _Ship.getType() + " " + _Ship.getCapacity());
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
