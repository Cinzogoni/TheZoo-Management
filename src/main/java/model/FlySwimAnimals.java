package model;

import java.time.LocalDate;

public class FlySwimAnimals extends Animal implements Flyable, Swimmable {

    public FlySwimAnimals() {
    }

    public FlySwimAnimals(String id, String name, LocalDate receivedDate, String healthStatus) {
        super(id, name, receivedDate, healthStatus);
    }

    @Override
    public String getMoveBehavior() {
        return fly() + swim();
    }

    @Override
    public String fly() {
        return "Dong vat biet bay ";
    }

    @Override
    public String swim() {
        return "va biet boi";
    } 
}
