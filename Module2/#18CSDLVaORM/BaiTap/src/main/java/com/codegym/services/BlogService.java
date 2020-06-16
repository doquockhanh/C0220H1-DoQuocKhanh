package com.codegym.services;

import com.codegym.models.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> getAllBlog();

    Blog getByIdBlog(Integer id);

    void deleteBlog(Integer id);

    void editBlog(Blog blog);

    void addBlog(Blog blog);

}
