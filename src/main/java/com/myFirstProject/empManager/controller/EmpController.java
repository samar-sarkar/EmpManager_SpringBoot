package com.myFirstProject.empManager.controller;

import org.springframework.web.bind.annotation.RestController;

import com.myFirstProject.empManager.model.EmployeeDTO;
import com.myFirstProject.empManager.service.EmployeeServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EmpController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @PostMapping("employees")
    public String createEmployee(@RequestBody EmployeeDTO employeedDto) {
        if (employeeServiceImp.createEmployee(employeedDto))
            return "Saved Successfull";
        return "Not Saved";
    }

    @GetMapping("employees")
    public List<EmployeeDTO> readEmployee() {
        return employeeServiceImp.readEmployee();
    }

    @GetMapping("employees/{id}")
    public Optional<EmployeeDTO> readEmployeeById(@PathVariable Long id) {
        return employeeServiceImp.readEmployeeById(id);
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO) {

        if (employeeServiceImp.updateEmployee(id, employeeDTO))
            return "Update Sucessfull";
        return "Not Found";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable long id) {
        if (employeeServiceImp.deleteEmployee(id))
            return "Delete Successfull";
        return "Not Found";
    }

}
