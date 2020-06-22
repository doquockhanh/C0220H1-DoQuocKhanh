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

    @Override
    public void saveCustomer(Customer customer) {
        Integer idGene = generateRanDomId();
        customer.setId(idGene);
        customerRepository.save(customer);
    }

    private Integer generateRanDomId(){
        Integer idGene = (int) (Math.random()*8999 + 1000);
        if(customerRepository.existsById(idGene)){
            generateRanDomId();
        }
        return idGene;
    }
}
