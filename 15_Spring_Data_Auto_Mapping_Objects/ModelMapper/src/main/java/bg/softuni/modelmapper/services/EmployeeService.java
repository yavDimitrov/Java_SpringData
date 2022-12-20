package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDTO;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO employeeDTO) {
    }
}
