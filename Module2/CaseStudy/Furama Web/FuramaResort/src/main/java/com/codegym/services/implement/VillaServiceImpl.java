package com.codegym.services.implement;

import com.codegym.models.rentalService.Villa;
import com.codegym.repositories.serviceRepo.VillaRepository;
import com.codegym.services.VillaService;
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


    //gan id cho villa moi duoc tao
    @Override
    public void saveVilla(Villa villa) {
        villa.setId(geneIdForEachVilla());
        villaRepository.save(villa);
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
