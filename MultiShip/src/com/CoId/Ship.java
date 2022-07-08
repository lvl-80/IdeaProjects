package com.CoId;

public class Ship {
    private static final ShipType[] TypeArray = new ShipType[]{ShipType.Bread,ShipType.Bananas,ShipType.Clothes};
    private ShipType Type;
    private int Capacity;
    Ship(ShipType _Type, int _Capacity){
        Type = _Type;
        Capacity = _Capacity*10;
    }
    public static ShipType[] getTypeArray(){
        return TypeArray;
    }
    public synchronized ShipType getType(){
        return Type;
    }
    public synchronized int getCapacity(){
        return Capacity;
    }
}
