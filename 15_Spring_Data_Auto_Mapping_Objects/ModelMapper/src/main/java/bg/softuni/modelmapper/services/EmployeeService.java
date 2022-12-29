package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDTO;
import bg.softuni.modelmapper.entities.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO employeeDTO);

    List<EmployeeDTO> findAll();
}
