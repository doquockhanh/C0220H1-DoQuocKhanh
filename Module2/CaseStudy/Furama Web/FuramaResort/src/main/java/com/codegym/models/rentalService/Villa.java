package com.codegym.models.rentalService;

import javax.persistence.Entity;

public class Villa extends FuramaService {

    private Integer id;
    private String numberOfFloor;

    public Villa(String name, String rentPrice, String numberOfFloor) {
        super(name, rentPrice);
        this.numberOfFloor = numberOfFloor;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
}
