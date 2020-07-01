package com.codegym.services.contract;

import com.codegym.models.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    void saveContractDetail(ContractDetail contractDetail);

    List<ContractDetail> getAllContractDetail();

    ContractDetail getContractDetailById(Integer id);

    void deleteContractDetailById(Integer id);
}
