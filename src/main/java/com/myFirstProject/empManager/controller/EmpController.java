package com.myFirstProject.empManager.controller;

import org.springframework.web.bind.annotation.RestController;

import com.myFirstProject.empManager.model.Employee;
import com.myFirstProject.empManager.service.EmployeeServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
public class EmpController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;


    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        if(employeeServiceImp.createEmployee(employee))
            return"Saved Successfull";
        return"Not Saved";
    }
    
    @GetMapping("employees")
    public List<Employee> readEmployee() {
        return employeeServiceImp.readEmployee();
    }
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable long id){
        if(employeeServiceImp.deleteEmployee(id))
            return "Delete Successfull";
        return "Not Found";
    }
    
}
