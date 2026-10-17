package model;

import java.time.LocalDate;

public class WalkingAnimals extends Animal implements Walkable {

    public WalkingAnimals() {
    }

    public WalkingAnimals(String id, String name, LocalDate receivedDate, String healthStatus) {
        super(id, name, receivedDate, healthStatus);
    }

    @Override
    public String getMoveBehavior() {
        return walk();
    }

    @Override
    public String walk() {
        return "Dong vat tren can";
    }
}
