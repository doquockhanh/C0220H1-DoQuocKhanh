package com.codegym.models.rentalService;

public class FuramaService {

    private String name;
    private String rentPrice;

    public FuramaService() {
    }

    public FuramaService(String name, String rentPrice) {
        this.name = name;
        this.rentPrice = rentPrice;
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
}
