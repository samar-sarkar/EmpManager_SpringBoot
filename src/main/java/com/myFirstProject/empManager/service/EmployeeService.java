package com.myFirstProject.empManager.service;

import java.util.List;

import com.myFirstProject.empManager.entity.Employee;
import com.myFirstProject.empManager.model.EmployeeDTO;

public interface EmployeeService {

    Boolean createEmployee(EmployeeDTO employeeDto);

    List<EmployeeDTO> readEmployee();

    Boolean deleteEmployee(long id);

}
