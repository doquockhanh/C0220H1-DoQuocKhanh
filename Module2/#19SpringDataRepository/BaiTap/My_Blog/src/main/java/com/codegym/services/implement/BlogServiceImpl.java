package com.codegym.services.implement;

import com.codegym.models.Blog;
import com.codegym.repository.BlogRepo;
import com.codegym.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepo blogRepo;

    @Override
    public Page<Blog> getAllBlog(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }



    @Override
    public Blog getByIdBlog(Integer id) {
        return blogRepo.getOne(id);
    }

    @Override
    public void deleteBlog(Integer id) {
         blogRepo.deleteById(id);
    }

    @Override
    public void editBlog(Blog blog) {
         blogRepo.save(blog);
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Page<Blog> findByNameContaining(String keyword, Pageable pageable) {
        return blogRepo.findByTitleContaining(keyword, pageable);
    }

    @Override
    public Page<Blog> findByCategory(Integer id, Pageable pageable) {
        return blogRepo.findAllByCategory_Id(id, pageable);
    }
}
