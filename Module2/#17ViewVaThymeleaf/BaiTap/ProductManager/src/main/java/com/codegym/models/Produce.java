package com.codegym.models;

public class Produce {
    private Integer Id;
    private String name;
    private String price;

    public Produce() {
    }

    public Produce(Integer id, String name, String price) {
        Id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
