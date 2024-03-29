package com.codegym.models.contract;

import com.codegym.models.contract.Contract;
import com.codegym.models.rentalService.AccompaniedService;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accompaniedservice_id", referencedColumnName = "id")
    private AccompaniedService accompaniedService;

    @OneToMany(mappedBy="contractdetail")
    private Set<Contract> contract;

    public ContractDetail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public AccompaniedService getAccompaniedService() {
        return accompaniedService;
    }

    public void setAccompaniedService(AccompaniedService accompaniedService) {
        this.accompaniedService = accompaniedService;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }
}
