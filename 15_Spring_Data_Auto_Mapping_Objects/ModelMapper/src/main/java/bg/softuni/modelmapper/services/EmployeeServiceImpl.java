package bg.softuni.modelmapper.services;

import bg.softuni.modelmapper.entities.Employee;
import bg.softuni.modelmapper.entities.dtos.CreateEmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee create(CreateEmployeeDTO employeeDTO) {
        return null;
    }
}
