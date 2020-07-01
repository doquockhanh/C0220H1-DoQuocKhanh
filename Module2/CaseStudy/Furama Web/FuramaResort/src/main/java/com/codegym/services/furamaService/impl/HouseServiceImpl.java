package com.codegym.services.furamaService.impl;

import com.codegym.models.rentalService.House;
import com.codegym.repositories.serviceRepo.HouseRepository;
import com.codegym.services.furamaService.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseRepository houseRepository;

    @Override
    public Page<House> getAllHousePaging(Pageable pageable) {
        return houseRepository.findAll(pageable);
    }

    @Override
    public void deleteHouseById(String id) {
        houseRepository.deleteHouseById(id);
    }

    @Override
    public House getHouseById(String id) {
        return houseRepository.getHouseById(id);
    }

    private String geneIdForEachHouse() {
        Integer idGene = 0;
        idGene = (int) (Math.random() * 8999 + 1000);
        if (houseRepository.existsHouseById("HO-" + (idGene))) {
            geneIdForEachHouse();
        }
        return "HO-" + (idGene);
    }

    @Override
    public void saveHouse(House house) {
        house.setId(geneIdForEachHouse());
        houseRepository.save(house);
    }
}
