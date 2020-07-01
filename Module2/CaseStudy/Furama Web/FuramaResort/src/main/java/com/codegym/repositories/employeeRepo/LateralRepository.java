package com.codegym.repositories.employeeRepo;

import com.codegym.models.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LateralRepository extends JpaRepository<Department, Integer> {
}
