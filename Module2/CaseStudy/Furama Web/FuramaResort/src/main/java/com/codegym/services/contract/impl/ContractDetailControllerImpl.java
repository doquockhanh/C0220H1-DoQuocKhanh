package com.codegym.services.contract.impl;

import com.codegym.models.contract.ContractDetail;
import com.codegym.repositories.contractRepo.ContractDetailRepository;
import com.codegym.services.contract.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailControllerImpl implements ContractDetailService {

    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> getAllContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail getContractDetailById(Integer id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContractDetailById(Integer id) {
        contractDetailRepository.deleteById(id);
    }
}
