package com.codegym.services;

import com.codegym.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void createCategory(Category category);

    Page<Category> getAllCategoryPaging(Pageable pageable);

    void deleteCategory(Integer id);

    Optional<Category> getCategoryById(Integer id);

    void saveCategory(Category category);

    Page<Category> getAllCategoryPagingByKeyWord(String keyWord, Pageable pageable);

    List<Category> getAllCategory();
}
