package model;

import java.time.LocalDate;

public class WalkSwimAnimals extends Animal implements Walkable, Swimmable {

    public WalkSwimAnimals() {
    }

    public WalkSwimAnimals(String id, String name, LocalDate receivedDate, String healthStatus) {
        super(id, name, receivedDate, healthStatus);
    }

    @Override
    public String getMoveBehavior() {
        return walk() + swim();
    }

    @Override
    public String walk() {
        return "Dong vat tren can ";
    }

    @Override
    public String swim() {
        return "va biet boi";
    }
}
