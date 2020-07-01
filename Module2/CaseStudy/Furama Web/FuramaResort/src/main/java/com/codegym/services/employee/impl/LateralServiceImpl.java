package com.codegym.services.employee.impl;

import com.codegym.models.employee.Department;
import com.codegym.repositories.employeeRepo.LateralRepository;
import com.codegym.services.employee.LateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LateralServiceImpl implements LateralService {

    @Autowired
    LateralRepository lateralRepository;

    @Override
    public void saveLateral(Department department) {
        lateralRepository.save(department);
    }

    @Override
    public List<Department> getAllLateral() {
        return lateralRepository.findAll();
    }

    @Override
    public void deleteLateral(Integer id) {
        lateralRepository.deleteById(id);
    }

    @Override
    public Department getLateralById(Integer id) {
        return lateralRepository.findById(id).orElse(null);
    }
}
