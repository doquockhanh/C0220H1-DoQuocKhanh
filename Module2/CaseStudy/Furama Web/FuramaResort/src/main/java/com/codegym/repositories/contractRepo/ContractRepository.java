package com.codegym.repositories.contractRepo;

import com.codegym.models.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, String> {
    boolean existsContractById(String id);

    Contract getContractById(String id);

    void deleteContractById(String id);
}
