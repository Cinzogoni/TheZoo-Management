package model;

import java.time.LocalDate;

public class FlyingAnimals extends Animal implements Flyable {

    public FlyingAnimals() {
    }
    
    public FlyingAnimals(String id, String name, LocalDate receivedDate, String healthStatus) {
        super(id, name, receivedDate, healthStatus);
    }   

    @Override
    public String getMoveBehavior() {
        return fly();
    }

    @Override
    public String fly() {
        return "Dong vay biet bay";
    }
}
