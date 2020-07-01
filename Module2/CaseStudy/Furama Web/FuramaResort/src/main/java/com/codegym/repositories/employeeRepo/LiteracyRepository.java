package com.codegym.repositories.employeeRepo;

import com.codegym.models.employee.Literacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiteracyRepository extends JpaRepository<Literacy, Integer> {
}
