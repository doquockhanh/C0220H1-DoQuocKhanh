package com.codegym.services.employee;

import com.codegym.models.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    void saveEmployee(Employee employee);

    Page<Employee> getAllEmployee(Pageable pageable);

    Employee getEmployeeById(String id);

    void deleteEmployeeById(String id);
}
