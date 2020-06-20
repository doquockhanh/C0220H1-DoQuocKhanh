package com.codegym.services.implement;

import com.codegym.models.Customer;
import com.codegym.repositories.CustomerRepository;
import com.codegym.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Integer idGene = 0;

    private void geneIdForEachCustomer(Customer customer){
        idGene+= 1;
        customer.setId("KH-" + (10000 + idGene));
    }

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        geneIdForEachCustomer(customer);
        customerRepository.save(customer);
    }
}
