package com.codegym.repository;

import com.codegym.models.Blog;

import java.util.List;

public interface BlogRepo {
    List<Blog> getAllBlog();

    Blog getByIdBlog(Integer id);

    void deleteBlog(Integer id);

    void editBlog(Integer id, String title, String content);

    void addBlog(String title, String content);
}
