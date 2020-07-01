package com.codegym.repositories.contractRepo;

import com.codegym.models.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
}
