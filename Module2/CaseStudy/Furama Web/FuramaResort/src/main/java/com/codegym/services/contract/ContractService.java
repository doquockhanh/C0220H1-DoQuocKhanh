package com.codegym.services.contract;

import com.codegym.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    void saveContract(Contract contract);

    Page<Contract> getAllContract(Pageable pageable);

    Contract getContractById(String id);

    void deleteContractById(String id);
}
