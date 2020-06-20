package com.codegym.repository;

import com.codegym.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepo extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContaining(String keyword, Pageable pageable);
}
