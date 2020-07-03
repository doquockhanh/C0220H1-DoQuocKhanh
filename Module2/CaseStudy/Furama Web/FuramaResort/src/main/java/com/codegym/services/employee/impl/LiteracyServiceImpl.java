package com.codegym.services.employee.impl;

import com.codegym.models.employee.Literacy;
import com.codegym.repositories.employeeRepo.LiteracyRepository;
import com.codegym.services.employee.LiteracyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LiteracyServiceImpl implements LiteracyService {

    @Autowired
    LiteracyRepository literacyRepository;

    @Override
    public void saveLateral(Literacy literacy) {
        literacyRepository.save(literacy);
    }

    @Override
    public List<Literacy> getAllLiteracy() {
        return literacyRepository.findAll();
    }

    @Override
    public void deleteLiteracy(Integer id) {
        literacyRepository.deleteById(id);
    }

    @Override
    public Literacy getLiteracyById(Integer id) {
        return literacyRepository.findById(id).orElse(null);
    }
}
