package com.codegym.models.rentalService;

import javax.persistence.*;

@MappedSuperclass
public abstract class FuramaService {

    protected String name;
    protected String rentPrice;
    protected Integer maxPeople;
    protected String rentType;

    public FuramaService() {
    }

    public FuramaService(String name, String rentPrice, Integer maxPeople, String rentType) {
        this.name = name;
        this.rentPrice = rentPrice;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
}
