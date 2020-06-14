package com.codegym.services.implement;

import com.codegym.models.Blog;
import com.codegym.repository.BlogRepo;
import com.codegym.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Qualifier(value = "My_Blog")
    @Autowired
    BlogRepo blogRepo;

    @Override
    public List<Blog> getAllBlog() {
        return blogRepo.getAllBlog();
    }

    @Override
    public Blog getByIdBlog(Integer id) {
        return blogRepo.getByIdBlog(id);
    }

    @Override
    public void deleteBlog(Integer id) {
         blogRepo.deleteBlog(id);
    }

    @Override
    public void editBlog(Integer id, String title, String content) {
         blogRepo.editBlog(id, title, content);
    }

    @Override
    public void addBlog(String title, String content) {
        blogRepo.addBlog(title, content);
    }
}
