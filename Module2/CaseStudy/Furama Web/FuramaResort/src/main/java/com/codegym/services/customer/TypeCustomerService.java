package com.codegym.services.customer;

import com.codegym.models.customer.TypeCustomer;

import java.util.List;

public interface TypeCustomerService {

    void saveTypeCustomer(TypeCustomer typeCustomer);

    List<TypeCustomer> getAllTypeCustomer();

    void deleteTypeCustomer(Integer id);

    TypeCustomer getTypeCustomerById(Integer id);

}
