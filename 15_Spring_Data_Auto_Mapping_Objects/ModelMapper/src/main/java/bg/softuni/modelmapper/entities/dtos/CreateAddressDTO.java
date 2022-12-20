package bg.softuni.modelmapper.entities.dtos;

public class CreateAddressDTO {

    private String county;

    private String city;

    public CreateAddressDTO(String county, String city) {
        this.county = county;
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public String getCity() {
        return city;
    }

}
