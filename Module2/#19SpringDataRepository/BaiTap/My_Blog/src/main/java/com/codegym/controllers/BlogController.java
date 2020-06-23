package com.codegym.controllers;

import com.codegym.models.Blog;
import com.codegym.models.Category;
import com.codegym.services.BlogService;
import com.codegym.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model, @RequestParam(value = "page", defaultValue = "1") String page,
                       @RequestParam Optional<String> keyword){
        try {
            Integer.parseInt(page);
        }
        catch (Exception e) {

        }

        model.addAttribute("allCategory", categoryService.getAll());

        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);
        Page<Category> categories = null;

        if(!keyword.isPresent()) {
            categories = categoryService.getAll(pageable);
        }else {
            categories = categoryService.findByNameContaining(keyword.get(), pageable);
            model.addAttribute("keyword", keyword.get());
        }
        model.addAttribute("categories", categories);
        return "home";
    }


    @GetMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category){
        categoryService.addCategory(category);
        return "redirect:/";
    }

    @GetMapping("/listBlog")
    public String listBlog(Model model, @RequestParam(value = "page", defaultValue = "1") String page,
                           @RequestParam Optional<String> keyword,
                           @RequestParam Integer id
    ) {

        try {
            Integer.parseInt(page);
        }
        catch (Exception e) {

        }

        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);
        Page<Blog> blogList = null;

        if(!keyword.isPresent()) {
            blogList = blogService.findByCategory(id, pageable);
        }else {
            blogList = blogService.findByNameContaining(keyword.get(), pageable);
            model.addAttribute("keyword", keyword.get());
        }
        model.addAttribute("blogs", blogList);

        return "listBlog";
    }

    @GetMapping("/editCategory")
    public String editCategory(Model model, @RequestParam Integer id){
        Category category = categoryService.getByIdCategory(id);
        model.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping("/editingCategory")
    public String editingCategory(@ModelAttribute Category category){
        categoryService.addCategory(category);
        return "redirect:/";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam Integer id){
        categoryService.deleteCategory(id);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam Integer id){
        blogService.deleteBlog(id);
        return "redirect:/";
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
        return "redirect:/";
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
        return "redirect:/";
    }
}
