package bg.softuni.hasEnitties;


import jakarta.persistence.*;

@Entity
@Table (name = "has_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private PlateNumber plateNumber;

    public Car () {

    }
}
