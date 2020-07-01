package com.codegym.services.customer.impl;

import com.codegym.models.customer.TypeCustomer;
import com.codegym.repositories.customerRepo.TypeCustomerRepository;
import com.codegym.services.customer.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCustomerServiceImpl implements TypeCustomerService {

    @Autowired
    TypeCustomerRepository typeCustomerRepository;

    @Override
    public void saveTypeCustomer(TypeCustomer typeCustomer) {
        typeCustomerRepository.save(typeCustomer);
    }

    @Override
    public List<TypeCustomer> getAllTypeCustomer() {
        return typeCustomerRepository.findAll();
    }

    @Override
    public void deleteTypeCustomer(Integer id) {
        typeCustomerRepository.deleteById(id);
    }

    @Override
    public TypeCustomer getTypeCustomerById(Integer id) {
        return typeCustomerRepository.findById(id).orElse(null);
    }
}
