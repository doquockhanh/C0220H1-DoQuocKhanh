package com.codegym.services;

import com.codegym.models.rentalService.Villa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VillaService {
    Page<Villa> getAllVilla(Pageable pageable);

    void saveVilla(Villa villa);
}
