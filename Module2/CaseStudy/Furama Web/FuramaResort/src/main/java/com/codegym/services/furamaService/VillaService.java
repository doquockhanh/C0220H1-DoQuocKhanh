package com.codegym.services.furamaService;

import com.codegym.models.rentalService.Villa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VillaService {
    Page<Villa> getAllVilla(Pageable pageable);

    void saveVilla(Villa villa);

    void deleteVillaById(String id);

    Villa getVillaById(String id);

    void editVilla(Villa villa);
}
