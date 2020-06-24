package com.codegym.repositories.serviceRepo;

import com.codegym.models.rentalService.Villa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillaRepository extends JpaRepository<Villa, String> {
    boolean existsVillaById(String id);
}
