package com.codegym.repositories.serviceRepo;

import com.codegym.models.rentalService.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, String> {
    boolean existsHouseById(String id);

    House getHouseById(String id);

    void deleteHouseById(String id);
}
