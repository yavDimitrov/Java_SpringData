package bg.softuni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Plane extends Vehicle {
    private static final String PLANE_TYPE = "PLANE";
    private int passengerCapacity;

    public Plane() {
        super(PLANE_TYPE);
    }

    public Plane(String model, String fuelType, int capacity){
        this();

        this.model = model;
        this.fuelType = fuelType;
        this.passengerCapacity = capacity;
    }
}
