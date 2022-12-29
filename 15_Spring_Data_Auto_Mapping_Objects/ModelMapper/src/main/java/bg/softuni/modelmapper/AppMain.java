package bg.softuni.modelmapper;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.AddressDTO;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDTO;
import bg.softuni.modelmapper.services.AddressService;
import bg.softuni.modelmapper.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class AppMain implements CommandLineRunner {

    private final AddressService addressService;
    private final EmployeeService employeeService;

    private final ModelMapper mapper;

    @Autowired
    public AppMain(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;

        this.mapper = new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);

    //    createAddress(scan);

   //     createEmployee(scan);

        printAllEmployees();
    }

    private void printAllEmployees() {
        this.employeeService.findAll().forEach(System.out::println);
    }

    private void createEmployee(Scanner scan) {
        String firstName = scan.nextLine();
        BigDecimal salary = new BigDecimal(scan.nextLine());
        LocalDate birthday = LocalDate.parse(scan.nextLine());

//        long addressId = Long.parseLong(scan.nextLine());

        String country = scan.nextLine();
        String city = scan.nextLine();

        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, address);

        Employee employee = this.employeeService.create(employeeDTO);

        System.out.println(employee);


    }

    private void createAddress(Scanner scan) {
        String country = scan.nextLine();
        String city = scan.nextLine();

        AddressDTO data = new AddressDTO(country, city);

        Address address = addressService.create(data);

        System.out.println(address);
    }
}
