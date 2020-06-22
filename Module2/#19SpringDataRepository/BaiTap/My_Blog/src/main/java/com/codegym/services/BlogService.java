package com.codegym.services;

import com.codegym.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    Page<Blog> getAllBlog(Pageable pageable);

    Blog getByIdBlog(Integer id);

    void deleteBlog(Integer id);

    void editBlog(Blog blog);

    void addBlog(Blog blog);

    Page<Blog> findByNameContaining(String keyword, Pageable pageable);

    Page<Blog> findByCategory(Integer id, Pageable pageable);
}
