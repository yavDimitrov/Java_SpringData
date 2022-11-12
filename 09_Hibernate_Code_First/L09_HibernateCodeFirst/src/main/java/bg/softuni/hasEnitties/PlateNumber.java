package bg.softuni.hasEnitties;

import jakarta.persistence.*;

@Entity
@Table( name = "has_plate_numbers")
public class PlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    public PlateNumber() {

    }
}
