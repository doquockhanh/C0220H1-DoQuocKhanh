package com.codegym.controllers;

import com.codegym.models.Blog;
import com.codegym.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public String home(Model model) {
        List<Blog> blogList = blogService.getAllBlog();
        model.addAttribute("blogs", blogList);
        return "home";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam Integer id){
        blogService.deleteBlog(id);
        List<Blog> blogList = blogService.getAllBlog();
        model.addAttribute("blogs", blogList);
        return "home";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Integer id){
        Blog blog = blogService.getByIdBlog(id);
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("/editing")
    public String editing(Model model, @ModelAttribute Blog blog){
        blogService.editBlog(blog);
        List<Blog> blogList = blogService.getAllBlog();
        model.addAttribute("blogs", blogList);
        return "home";
    }

    @GetMapping("/view")
    public String view(Model model, @RequestParam Integer id){
        Blog blog = blogService.getByIdBlog(id);
        model.addAttribute("blog", blog);
        return "view";
    }

    @GetMapping("/add")
    public String add(Model model, @ModelAttribute Blog blog){
        blogService.addBlog(blog);
        List<Blog> blogList = blogService.getAllBlog();
        model.addAttribute("blogs", blogList);
        return "home";
    }
}
