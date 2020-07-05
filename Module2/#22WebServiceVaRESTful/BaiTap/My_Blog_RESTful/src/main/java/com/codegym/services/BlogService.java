package com.codegym.services;

import com.codegym.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    void createBlog(Blog blog);

    Page<Blog> getBlogByIdCategory(Integer id, Pageable pageable);

    List<Blog> getBlogByIdCategory(Integer id);

    void deleteBlog(Integer id);

    Optional<Blog> getBlogById(Integer id);

    void editPost(Blog blog);

    Page<Blog> getBlogByIdCategoryAndKeyWork(String keyWord, Integer id, Pageable pageable);

    List<Blog> getAllBlog();
}
