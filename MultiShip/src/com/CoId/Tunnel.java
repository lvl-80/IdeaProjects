package com.CoId;

import java.util.*;

public class Tunnel {
    private final ArrayList<Ship> ShipArray = new ArrayList<>();
    public synchronized void add(Ship ship){
        try {
            if (ShipArray.size() < 5){
                ShipArray.add(ship);
                notifyAll();
            }else
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public synchronized Ship get(ShipType _Type) {
        if (ShipArray.size() > 0) {
            for (Ship _Ship : ShipArray)
                if (_Ship.getType() == _Type) {
                    ShipArray.remove(_Ship);
                    return _Ship;
                }
            notifyAll();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
