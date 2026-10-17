package model;

import java.time.LocalDate;

public class TriathlonAnimals extends Animal implements Walkable, Flyable, Swimmable {

    public TriathlonAnimals() {
    }

    public TriathlonAnimals(String id, String name, LocalDate receivedDate, String healthStatus) {
        super(id, name, receivedDate, healthStatus);
    }

    @Override
    public String getMoveBehavior() {
        return walk() + fly() + swim();
    }

    @Override
    public String walk() {
        return "Dong vat tren can, ";
    }

    @Override
    public String fly() {
        return "biet bay ";
    }

    @Override
    public String swim() {
        return "va duoi nuoc";
    }  
}
