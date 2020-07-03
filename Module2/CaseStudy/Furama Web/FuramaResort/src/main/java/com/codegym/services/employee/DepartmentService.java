package com.codegym.services.employee;

import com.codegym.models.employee.Department;

import java.util.List;

public interface DepartmentService {

    void saveDepartment(Department department);

    List<Department> getAllDepartment();

    void deleteDepartment(Integer id);

    Department getDepartmentById(Integer id);

    void editDepartment( Department  department);
}
