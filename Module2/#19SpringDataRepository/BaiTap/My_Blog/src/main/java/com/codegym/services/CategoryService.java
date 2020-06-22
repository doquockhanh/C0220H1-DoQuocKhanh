package com.codegym.services;

import com.codegym.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    Page<Category> getAll(Pageable pageable);
    List<Category> getAll();
    Category getByIdCategory(Integer id);
    void deleteCategory(Integer id);
    void editCategory(Category category);
    Page<Category> findByNameContaining(String keyword, Pageable pageable);
}
