package com.codegym.services.employee;

import com.codegym.models.employee.Department;

import java.util.List;

public interface LateralService {

    void saveLateral(Department department);

    List<Department> getAllLateral();

    void deleteLateral(Integer id);

    Department getLateralById(Integer id);

}
