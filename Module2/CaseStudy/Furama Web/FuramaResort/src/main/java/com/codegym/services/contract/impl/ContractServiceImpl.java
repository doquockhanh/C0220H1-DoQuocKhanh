package com.codegym.services.contract.impl;

import com.codegym.models.contract.Contract;
import com.codegym.repositories.contractRepo.ContractRepository;
import com.codegym.services.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> getAllContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract getContractById(String id) {
        return contractRepository.getContractById(id);
    }

    @Override
    public void deleteContractById(String id) {
        contractRepository.deleteContractById(id);
    }

    @Override
    public void editContract(Contract contract) {
        contractRepository.save(contract);
    }
}
