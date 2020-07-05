package com.codegym.repository;

import com.codegym.models.Produce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduceRepository extends JpaRepository<Produce, Integer> {
}
