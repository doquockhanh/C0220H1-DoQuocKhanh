package com.codegym.services.customer;

import com.codegym.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    void saveCustomer(Customer customer);

    Page<Customer> getAllCustomer(Pageable pageable);

    Customer getCustomerById(String id);

    void deleteCustomerById(String id);

    void editCustomer(Customer customer);
}
