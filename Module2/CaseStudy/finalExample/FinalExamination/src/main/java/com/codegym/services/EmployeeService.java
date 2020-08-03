package com.codegym.services;

import com.codegym.models.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void deleteEmployee(Integer id);

    List<Employee> getAllEmployee();

    List<Employee> getEmployeeByKeyWord(Integer id, String birthDay, String idCard);
}
