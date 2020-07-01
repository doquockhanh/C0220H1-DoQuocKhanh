package com.codegym.services.furamaService.impl;

import com.codegym.models.rentalService.Villa;
import com.codegym.repositories.serviceRepo.VillaRepository;
import com.codegym.services.furamaService.VillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VillaServiceImpl implements VillaService {

    @Autowired
    VillaRepository villaRepository;

    @Override
    public Page<Villa> getAllVilla(Pageable pageable) {
        return villaRepository.findAll(pageable);
    }


    @Override
    public void saveVilla(Villa villa) {
        villa.setId(geneIdForEachVilla());
        villaRepository.save(villa);
    }

    @Override
    public void deleteVillaById(String id) {
        villaRepository.deleteVillaById(id);
    }

    @Override
    public Villa getVillaById(String id) {
        return villaRepository.getVillaById(id);
    }

    private String geneIdForEachVilla(){
        Integer idGene = 0;
        idGene = (int) (Math.random()*8999 + 1000);
        if(villaRepository.existsVillaById("VL-" + (idGene))){
            geneIdForEachVilla();
        }
        return "VL-" + (idGene);
    }
}
