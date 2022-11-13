package bg.softuni.hasEnitties;

import jakarta.persistence.*;

@Entity
@Table( name = "plate_numbers")
public class PlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @OneToOne(targetEntity = Truck.class, mappedBy = "plateNumber")
    private Truck truck;

    public PlateNumber() {

    }

    public PlateNumber(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public PlateNumber(String s) {
        this.number = s;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
