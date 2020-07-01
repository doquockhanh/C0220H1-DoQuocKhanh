package com.codegym.models.rentalService;

import com.codegym.models.contract.ContractDetail;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AccompaniedService {

    @Id
    private String id;
    private String price;
    private Integer amount;

    @OneToOne(mappedBy = "accompaniedService")
    private ContractDetail contractDetail;

    public AccompaniedService() {
    }

    public AccompaniedService(String id, String price, Integer amount) {
        this.id = id;
        this.price = price;
        this.amount = amount;
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
