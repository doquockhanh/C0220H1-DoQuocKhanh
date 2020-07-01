package com.codegym.models.customer;

import javax.persistence.*;

@Entity
public class TypeCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToOne(mappedBy = "typeCustomer")
    private Customer customer;

    public TypeCustomer() {
    }

    public TypeCustomer(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
