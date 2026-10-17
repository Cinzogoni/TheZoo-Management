package model;

import java.time.LocalDate;
import utils.Validates;

public abstract class Animal {

    private String id;
    private String name;
    private LocalDate receivedDate;
    private String healthStatus;

    public Animal() {
    }

    public Animal(String id, String name, LocalDate receivedDate, String healthStatus) {
        this.id = id;
        this.name = name;
        this.receivedDate = receivedDate;
        this.healthStatus = healthStatus;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public String getHealthStatus() {
        return healthStatus;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
    
    public abstract String getMoveBehavior();

    @Override
    public String toString() {
        String recievedDateStr = (receivedDate == null) ? "N/A" : receivedDate.format(Validates.FMT);
        return id + " - " + name + " - " + recievedDateStr + " - " + healthStatus + " - " + getMoveBehavior();
    }
}
