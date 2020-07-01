package com.codegym.repositories.customerRepo;

import com.codegym.models.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsCustomerById(String id);

    Customer getCustomerById(String id);

    void deleteCustomerById(String id);
}
