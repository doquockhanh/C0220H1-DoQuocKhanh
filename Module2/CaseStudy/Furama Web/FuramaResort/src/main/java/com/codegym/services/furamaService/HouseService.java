package com.codegym.services.furamaService;

import com.codegym.models.rentalService.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HouseService {
    Page<House> getAllHousePaging(Pageable pageable);

    void saveHouse(House house);

    void deleteHouseById(String id);

    House getHouseById(String id);

    void editHouse(House house);
}
