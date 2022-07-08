package com.CoId;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Dash implements Runnable{
    private Horse horse;
    private Area area;
    private CyclicBarrier barrier;
    public Dash(Horse _horse, Area _area, CyclicBarrier _barrier){
        horse = _horse;
        area = _area;
        barrier = _barrier;
    }
    @Override
    public void run(){
        while (!area.getFinished()) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(area.horsePosition(horse.getId()))
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
        }
    }
}
