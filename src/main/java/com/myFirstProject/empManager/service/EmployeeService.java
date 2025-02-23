package com.myFirstProject.empManager.service;

import java.util.List;

import com.myFirstProject.empManager.model.Employee;

public interface EmployeeService {

    Boolean createEmployee(Employee employee);
    List<Employee> readEmployee();
    Boolean deleteEmployee(long id);
    
} 
