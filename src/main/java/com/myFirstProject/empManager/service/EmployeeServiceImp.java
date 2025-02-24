package com.myFirstProject.empManager.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myFirstProject.empManager.entity.Employee;
import com.myFirstProject.empManager.mapper.EmployeeMapper;
import com.myFirstProject.empManager.model.EmployeeDTO;
import com.myFirstProject.empManager.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Boolean createEmployee(EmployeeDTO employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        employeeRepository.save(employee);

        return true;
    }

    @Override
    public List<EmployeeDTO> readEmployee() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmployeeDTO> readEmployeeById(Long id) {
        return employeeRepository.findById(id).map(employeeMapper::toDTO);
    }

    @Override
    public Boolean updateEmployee(long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
        employee.setName(employeeDTO.getName());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEmail(employeeDTO.getEmail());
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public Boolean deleteEmployee(long id) {
        employeeRepository.deleteById(id);
        return true;
    }

}
