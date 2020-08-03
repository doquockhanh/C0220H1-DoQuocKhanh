package com.codegym.repositories;

import com.codegym.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    boolean existsEmployeeById(Integer id);

    List<Employee> findEmployeesByIdOrBirthDayOrIdCard(Integer id, String birthDay, String idCard);
}
