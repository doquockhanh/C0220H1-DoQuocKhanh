package com.codegym.controllers;

import com.codegym.models.Blog;
import com.codegym.models.Category;
import com.codegym.services.BlogService;
import com.codegym.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyBlogRESTController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCategory")
    public ResponseEntity<List<Category>> getListOfCategory(){
        return new ResponseEntity<>(categoryService.getAllCategory() , HttpStatus.OK);
    }

    @GetMapping("/getAllBlog")
    public ResponseEntity<List<Blog>> getListOfBlog(){
        return new ResponseEntity<>(blogService.getAllBlog() , HttpStatus.OK);
    }

    @GetMapping("/getAllBlogOfCategory/{id}")
    public ResponseEntity<List<Blog>> getListOfBlogByCategoryId(@PathVariable String id){
        return new ResponseEntity<>(blogService.getBlogByIdCategory(Integer.parseInt(id)) , HttpStatus.OK);
    }

    @GetMapping("/detailPost/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable String id){
        return new ResponseEntity<>(blogService.getBlogById(Integer.parseInt(id)).get() , HttpStatus.OK);
    }
}
