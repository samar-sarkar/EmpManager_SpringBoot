package com.myFirstProject.empManager.service;

import java.util.List;
import java.util.Optional;

import com.myFirstProject.empManager.model.EmployeeDTO;

public interface EmployeeService {

    Boolean createEmployee(EmployeeDTO employeeDto);

    List<EmployeeDTO> readEmployee();

    Optional<EmployeeDTO> readEmployeeById(Long id);

    Boolean updateEmployee(long id, EmployeeDTO employeeDTO);

    Boolean deleteEmployee(long id);

}
