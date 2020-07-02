package com.codegym.models.rentalService;

import com.codegym.models.contract.Contract;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Room extends FuramaService{
    @Id
    protected String id;
    private String freeService;
    private String imageSource;

    @OneToOne(mappedBy = "room")
    private Contract contract;

    public Room() {
    }

    public Room(String name, String rentPrice, Integer maxPeople, String rentType, String id, String freeService, String imageSource, Contract contract) {
        super(name, rentPrice, maxPeople, rentType);
        this.id = id;
        this.freeService = freeService;
        this.imageSource = imageSource;
        this.contract = contract;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
