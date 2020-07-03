package com.codegym.services.employee;

import com.codegym.models.employee.Position;

import java.util.List;

public interface PositionService {

    void savePosition(Position position);

    List<Position> getAllPosition();

    void deletePosition(Integer id);

    Position getPositionById(Integer id);

    void editPosition(Position position);
}
