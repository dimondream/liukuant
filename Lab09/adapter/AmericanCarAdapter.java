package adapter;

import cars.Car;

/**
 * AmericanCarAdapter adapter.  Make an american car report speed in km
 */
public class AmericanCarAdapter implements Car {
    Car car;

    public AmericanCarAdapter(Car car){
        this.car=car;

    }
    @Override
    public double maxSpeed(){
        return (int)(this.car.maxSpeed() * 1.609);
    }
    @Override
    public String getUnits(){
        return "kilometers per hour";
    }
    @Override
    public String getName(){
        return "Adapted" + car.getName();
    }
}
