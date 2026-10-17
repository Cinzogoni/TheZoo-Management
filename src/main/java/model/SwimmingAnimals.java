package model;

import java.time.LocalDate;

public class SwimmingAnimals extends Animal implements Swimmable {

    public SwimmingAnimals() {
    }

    public SwimmingAnimals(String id, String name, LocalDate receivedDate, String healthStatus) {
        super(id, name, receivedDate, healthStatus);
    }

    @Override
    public String getMoveBehavior() {
        return swim();
    }

    @Override
    public String swim() {
        return "Dong vat biet boi";
    }
    
    
}
