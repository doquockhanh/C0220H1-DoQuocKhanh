package com.codegym.repositories.serviceRepo;

import com.codegym.models.rentalService.AccompaniedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccompaniedServiceRepository extends JpaRepository<AccompaniedService, String> {
    boolean existsAccompaniedServiceById(String id);

    AccompaniedService getAccompaniedServiceById(String id);

    void deleteAccompaniedServiceById(String id);
}
