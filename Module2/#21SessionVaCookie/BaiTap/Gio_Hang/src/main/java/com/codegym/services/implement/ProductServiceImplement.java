package com.codegym.services.implement;

import com.codegym.models.Product;
import com.codegym.repositories.ProductRepository;
import com.codegym.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getById(Integer Id) {
        return productRepository.getOne(Id);
    }
}
