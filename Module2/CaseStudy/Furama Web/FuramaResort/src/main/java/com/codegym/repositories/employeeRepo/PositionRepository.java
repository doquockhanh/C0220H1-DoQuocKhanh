package com.codegym.repositories.employeeRepo;

import com.codegym.models.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
