package com.codegym.services;

import com.codegym.models.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getById(Integer id);
}
