package StrategyDesignPattern;

interface GearSystem {
    public void whichGearSystem();
}

class ManualGearSystem implements GearSystem{

    @Override
    public void whichGearSystem(){
        System.out.println("Manual Gear System");
    }
}

class AutomaticGearSystem implements GearSystem{

    @Override
    public void whichGearSystem(){
        System.out.println("Automatic Gear System");
    }
}

public class Car {
    private GearSystem gearSystem;

    public Car(GearSystem gearSystem){
        this.gearSystem = gearSystem;
    }

    public void showGearSystem(){
        gearSystem.whichGearSystem();
    }

    public static void main(String[] args) {
        // System.out.println("Hello");
        ElectricCar car = new ElectricCar();
        car.showGearSystem();

    }
}

class ElectricCar extends Car {

    public ElectricCar(){
        super(new ManualGearSystem());
    }
}

class DieselCar extends Car {

    public DieselCar(){
        super(new AutomaticGearSystem());
    }
}