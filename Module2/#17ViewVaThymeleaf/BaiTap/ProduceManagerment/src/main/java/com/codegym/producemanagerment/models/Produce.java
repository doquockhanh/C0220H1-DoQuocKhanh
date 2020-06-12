package com.codegym.producemanagerment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produce {

    @Id
    @GeneratedValue
    private Integer Id;
    private String name;
    private String price;

    public Produce() {
    }

    public Produce(String name, String price) {
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
