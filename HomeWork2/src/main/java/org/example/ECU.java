package org.example;

public class ECU {
    public static void main(String[] args) {
        Base base=new Base();
        Car car=new Car();
        base.start();
        car.status();
        if(car.StatusOfElementCar()) base.drive();
        else car.warning();
        base.stop();

    }
}
