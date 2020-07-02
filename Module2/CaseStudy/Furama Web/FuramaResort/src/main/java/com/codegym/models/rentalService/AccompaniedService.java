package com.codegym.models.rentalService;

import com.codegym.models.contract.ContractDetail;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AccompaniedService {

    @Id
    private String id;
    private String name;
    private String price;
    private Integer amount;

    @OneToOne(mappedBy = "accompaniedService")
    private ContractDetail contractDetail;

    public AccompaniedService() {
    }

    public AccompaniedService(String id, String name, String price, Integer amount, ContractDetail contractDetail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.contractDetail = contractDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
