package com.codegym.services.employee.impl;

import com.codegym.models.employee.Employee;
import com.codegym.repositories.employeeRepo.EmployeeRepository;
import com.codegym.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employee.setId(geneIdForEachEmployee());
        employeeRepository.save(employee);
    }

    private String geneIdForEachEmployee(){
        Integer idGene = 0;
        idGene = (int) (Math.random()*8999 + 1000);
        if(employeeRepository.existsEmployeeById("EM-" + (idGene))){
            geneIdForEachEmployee();
        }
        return "EM-" + (idGene);
    }

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
