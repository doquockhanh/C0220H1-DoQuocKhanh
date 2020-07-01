package com.codegym.repositories.employeeRepo;

import com.codegym.models.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    boolean existsEmployeeById(String id);

    Employee getEmployeeById(String id);

    void deleteEmployeeById(String id);
}
