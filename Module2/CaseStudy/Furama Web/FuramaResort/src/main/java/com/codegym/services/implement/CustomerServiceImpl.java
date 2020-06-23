package com.codegym.services.implement;

import com.codegym.models.Customer;
import com.codegym.repositories.CustomerRepository;
import com.codegym.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    private Integer idGene = 0;

    private String geneIdForEachCustomer(){
        idGene = (int) (Math.random()*8999 + 1000);
        if(customerRepository.existsCustomerById("KH-" + (idGene))){
            geneIdForEachCustomer();
        }
        return "KH-" + (idGene);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customer.setId(geneIdForEachCustomer());
        customerRepository.save(customer);
    }
}
