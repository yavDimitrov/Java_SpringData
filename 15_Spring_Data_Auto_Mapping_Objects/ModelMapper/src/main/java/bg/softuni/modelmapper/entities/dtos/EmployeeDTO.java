package bg.softuni.modelmapper.entities.dtos;

import bg.softuni.modelmapper.entities.Employee;

import java.math.BigDecimal;

public class EmployeeDTO {

    private String firstName;

    private BigDecimal salary;

    private String City;

    public EmployeeDTO() {}

    public EmployeeDTO(Employee employee) {
        this.firstName = employee.getFirstName();
        this.salary = employee.getSalary();
    }

    public EmployeeDTO(String firstName, BigDecimal salary, String city) {
        this.firstName = firstName;
        this.salary = salary;
        City = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", City='" + City + '\'' +
                '}';
    }
}
