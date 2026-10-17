package model;

import java.time.LocalDate;

public class WalkFlyAnimals extends Animal implements Walkable, Flyable {

    public WalkFlyAnimals() {
    }

    public WalkFlyAnimals(String id, String name, LocalDate receivedDate, String healthStatus) {
        super(id, name, receivedDate, healthStatus);
    }

    @Override
    public String getMoveBehavior() {
        return walk() + ", "+ fly();
    }

    @Override
    public String walk() {
        return "Dong vat tren can ";
    }

    @Override
    public String fly() {
        return "va biet bay";
    }
}
