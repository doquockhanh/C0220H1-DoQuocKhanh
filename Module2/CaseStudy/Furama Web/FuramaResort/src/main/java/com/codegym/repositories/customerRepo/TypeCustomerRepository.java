package com.codegym.repositories.customerRepo;

import com.codegym.models.customer.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCustomerRepository extends JpaRepository<TypeCustomer, Integer> {
}
