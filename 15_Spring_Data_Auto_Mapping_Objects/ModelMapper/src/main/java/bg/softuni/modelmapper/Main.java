package bg.softuni.modelmapper;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Main implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        ModelMapper mapper = new ModelMapper();

        Address address = new Address("Bulgaria", "Sofia");

        Employee employee = new Employee("First", BigDecimal.TEN, address);

        EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);

/*        EmployeeDTO employeeDTO ? */

        System.out.println(employeeDTO.toString());
    }
}
