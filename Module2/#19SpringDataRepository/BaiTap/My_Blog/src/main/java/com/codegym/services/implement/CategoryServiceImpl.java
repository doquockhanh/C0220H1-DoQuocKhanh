package com.codegym.services.implement;

import com.codegym.models.Category;
import com.codegym.repository.CategoryRepo;
import com.codegym.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public void editCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Page<Category> findByNameContaining(String keyword, Pageable pageable) {
        return categoryRepo.findByNameContaining(keyword, pageable);
    }
}
