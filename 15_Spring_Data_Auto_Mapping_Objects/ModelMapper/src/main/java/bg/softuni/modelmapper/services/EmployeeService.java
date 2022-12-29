package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDTO;
import org.modelmapper.ModelMapper;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO employeeDTO);
}
