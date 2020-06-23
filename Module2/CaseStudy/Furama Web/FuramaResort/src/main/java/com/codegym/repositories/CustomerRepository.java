package com.codegym.repositories;

import com.codegym.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsCustomerById(String id);
}
