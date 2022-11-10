package bg.softuni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    private static final String CAR_TYPE = "CAR";
    private int seats;

    public Car() {
        super(CAR_TYPE);
    }

    public Car(String model, String fuelType, int seats){
        this();

        this.model = model;
        this.fuelType = fuelType;
        this.seats = seats;
    }
}
