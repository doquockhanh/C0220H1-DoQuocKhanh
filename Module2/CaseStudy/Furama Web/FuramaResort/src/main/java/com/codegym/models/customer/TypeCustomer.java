package com.codegym.models.customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TypeCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "typeCustomer", cascade = CascadeType.ALL)
    private Set<Customer> customers;

    public TypeCustomer() {
    }

    public TypeCustomer(String name, Set<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
