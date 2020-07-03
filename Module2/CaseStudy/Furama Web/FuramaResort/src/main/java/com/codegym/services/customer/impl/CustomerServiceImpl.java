package com.codegym.services.customer.impl;

import com.codegym.models.customer.Customer;
import com.codegym.repositories.customerRepo.CustomerRepository;
import com.codegym.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    private String geneIdForEachCustomer(){
        Integer idGene = 0;
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

    @Override
    public Page<Customer> getAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public void deleteCustomerById(String id) {
         customerRepository.deleteCustomerById(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
