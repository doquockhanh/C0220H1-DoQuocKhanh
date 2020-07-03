package com.codegym.services.employee.impl;

import com.codegym.models.employee.Department;
import com.codegym.repositories.employeeRepo.DepartmentRepository;
import com.codegym.services.employee.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public void editDepartment(Department department) {
        departmentRepository.save(department);
    }
}
