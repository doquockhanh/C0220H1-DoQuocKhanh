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

    @OneToOne(mappedBy = "room")
    private Contract contract;

    public Room() {
    }

    public Room(String name, String rentPrice, Integer maxPeople, String rentType, String id, String freeService) {
        super(name, rentPrice, maxPeople, rentType);
        this.id = id;
        this.freeService = freeService;
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
