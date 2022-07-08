package com.CoId;

import java.util.Random;

public class Area {
    private int[] size = new int[]{3,20};
    private final char[][] area = new char[size[0]][size[1]];
    private boolean finished = false;
    private Horse[] horses = new Horse[size[0]];
    private Horse winner;

    public Area(Horse[] _horses){
        for(int i = 0; i < size[0]; i++)
            for (int j = 0; j < size[1]; j++) {
                if (j == 0) area[i][j] = '@';
                else area[i][j] = '□';
            }
        horses = _horses;
    }
    public synchronized boolean getFinished(){
        return finished;
    }
    public synchronized int[] getSize(){
        return size;
    }
    public synchronized void setFinished(boolean _finished){
        finished = _finished;
    }
    public synchronized Horse getWinner(){
        return winner;
    }
    public synchronized void redraw(){
        for(int k = 0; k < size[1] + 3; k++)  System.out.print("-");System.out.println(" ");
        for(int i = 0; i < size[0]; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size[1]; j++)
                System.out.print(area[i][j]);
            System.out.print("F");
            System.out.println(" ");
        }
        for(int k = 0; k < size[1] + 3; k++) System.out.print("-");
        System.out.println(" ");
        notifyAll();
    }
    public synchronized boolean horsePosition(int _id){
        int index = 0;
        int _position = new Random().nextInt(3)+1;
        while(index < area[_id].length){
            if(area[_id][index] == '@'){
                area[_id][index] = '□';
                if (index + _position < area[_id].length)
                    area[_id][index + _position] = '@';
                else {
                    area[_id][size[1] - 1] = '@';
                    redraw();
                    winner = horses[_id];
                    return true;
                }
                break;
            }
            index += 1;
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}