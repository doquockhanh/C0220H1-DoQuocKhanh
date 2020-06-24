package com.codegym.services.implement;

import com.codegym.models.Blog;
import com.codegym.repositories.BlogRepository;
import com.codegym.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> getBlogByIdCategory(Integer id, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(id, pageable);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> getBlogById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void editPost(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> getBlogByIdCategoryAndKeyWork(String keyWord, Integer id, Pageable pageable) {
        return blogRepository.findAllByTitleContainingAndCategory_Id(keyWord,id,pageable);
    }
}
