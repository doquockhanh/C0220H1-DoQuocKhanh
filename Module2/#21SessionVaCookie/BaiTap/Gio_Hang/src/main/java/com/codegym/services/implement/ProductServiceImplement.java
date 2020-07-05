package com.codegym.services.implement;

import com.codegym.models.Product;
import com.codegym.repositories.ProductRepository;
import com.codegym.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }
}
