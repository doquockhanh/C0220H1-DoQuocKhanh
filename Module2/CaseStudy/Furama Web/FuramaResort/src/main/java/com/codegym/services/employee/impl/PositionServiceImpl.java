package com.codegym.services.employee.impl;

import com.codegym.models.employee.Position;
import com.codegym.repositories.employeeRepo.PositionRepository;
import com.codegym.services.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionRepository positionRepository;

    @Override
    public void savePosition(Position position) {
        positionRepository.save(position);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public void deletePosition(Integer id) {
        positionRepository.deleteById(id);
    }

    @Override
    public Position getPositionById(Integer id) {
        return positionRepository.findById(id).orElse(null);
    }
}
