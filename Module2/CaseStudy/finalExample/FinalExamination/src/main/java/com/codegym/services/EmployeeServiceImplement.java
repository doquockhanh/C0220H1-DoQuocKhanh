package com.codegym.services;

import com.codegym.models.Employee;
import com.codegym.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplement implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        employee.setId(geneIdForEachEmployee());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeeByKeyWord(Integer id, String birthDay, String idCard) {
        return employeeRepository.findEmployeesByIdOrBirthDayOrIdCard(id, birthDay, idCard);
    }

    private Integer geneIdForEachEmployee() {
        Integer idGene = 0;
        idGene = (int) (Math.random() * 8999 + 1000);
        if (employeeRepository.existsEmployeeById(idGene)) {
            geneIdForEachEmployee();
        }
        return idGene;
    }
}
