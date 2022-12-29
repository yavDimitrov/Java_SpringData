package bg.softuni.modelmapper;

import bg.softuni.modelmapper.entities.Address;
import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

//@Component
public class ModelMapperMain implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        ModelMapper mapper = new ModelMapper();

/*        PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<Employee, EmployeeDTO>() {
            @Override
            protected void configure() {
                map().setCity(source.getAddress().getCity());
            }
        };
        mapper.addMappings(propertyMap);*/

        TypeMap<Employee, EmployeeDTO> typeMap = mapper.createTypeMap(Employee.class, EmployeeDTO.class);
        /*
                typeMap.addMappings(mappings -> mappings.map
                (source -> source.getAddress().getCity(),
                        (destination, value) -> destination.setCity(value.toString())));

                 typeMap.validate();
        */

        typeMap.addMappings(mappings -> mappings.map
                (source -> source.getAddress().getCity(),
                       EmployeeDTO::setAddressCity));



        typeMap.validate();




        Address address = new Address("Bulgaria", "Sofia");
        Employee employee = new Employee("First", BigDecimal.TEN, address);

        EmployeeDTO employeeDTO = typeMap.map(employee);

        System.out.println(employeeDTO);

    }
}
