package com.codegym.services.furamaService.impl;

import com.codegym.models.rentalService.AccompaniedService;
import com.codegym.repositories.serviceRepo.AccompaniedServiceRepository;
import com.codegym.services.furamaService.AccompaniedService_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccompaniedService_ServiceImpl implements AccompaniedService_Service {

    @Autowired
    AccompaniedServiceRepository accompaniedServiceRepository;

    @Override
    public void saveAccompaniedService(AccompaniedService accompaniedService) {
        accompaniedService.setId(geneIdForEachAccompaniedService());
        accompaniedServiceRepository.save(accompaniedService);
    }

    private String geneIdForEachAccompaniedService() {
        Integer idGene = 0;
        idGene = (int) (Math.random() * 8999 + 1000);
        if (accompaniedServiceRepository.existsAccompaniedServiceById("DVDK-" + (idGene))) {
            geneIdForEachAccompaniedService();
        }
        return "DVDK-" + (idGene);
    }

    @Override
    public List<AccompaniedService> getAllAccompaniedService() {
        return accompaniedServiceRepository.findAll();
    }

    @Override
    public void deleteAccompaniedServiceById(String id) {
        accompaniedServiceRepository.deleteAccompaniedServiceById(id);
    }

    @Override
    public AccompaniedService getAccompaniedServiceById(String id) {
        return accompaniedServiceRepository.getAccompaniedServiceById(id);
    }

    @Override
    public void editAccompaniedService(AccompaniedService accompaniedService) {
        accompaniedServiceRepository.save(accompaniedService);
    }
}
