package com.myFirstProject.empManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myFirstProject.empManager.model.Employee;
import com.myFirstProject.empManager.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Boolean createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public List<Employee> readEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Boolean deleteEmployee(long id) {
        employeeRepository.deleteById(id);
        return true;
    }
    
}
