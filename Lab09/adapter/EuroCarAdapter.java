package adapter;

import cars.Car;

import  java.lang.Math;

/**
 * EuroCarAdapter adapter.  Make a european car report speed in miles
 */
public class EuroCarAdapter implements Car {
    Car car;

    public EuroCarAdapter(Car car){
        this.car=car;

    }
    @Override
    public double maxSpeed(){
        return (int)(this.car.maxSpeed() * 0.6213);
    }
    @Override
    public String getUnits(){
        return "miles per hour";
    }
    @Override
    public String getName(){
        return "Adapted" + car.getName();
    }
}
