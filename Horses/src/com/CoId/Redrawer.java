package com.CoId;

public class Redrawer implements Runnable{
    private Area area;
    public Redrawer(Area _area){
        area = _area;
    }
    @Override
    public void run(){
        while(!area.getFinished()){
            area.redraw();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
