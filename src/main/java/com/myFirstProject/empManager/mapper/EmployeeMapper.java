package com.myFirstProject.empManager.mapper;

import org.springframework.stereotype.Component;

import com.myFirstProject.empManager.entity.Employee;
import com.myFirstProject.empManager.model.EmployeeDTO;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName(employee.getName());
        dto.setPhone(employee.getPhone());
        dto.setEmail(employee.getEmail());
        return dto;

    }

    public Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEmail(employeeDTO.getEmail());
        return employee;
    }

}
