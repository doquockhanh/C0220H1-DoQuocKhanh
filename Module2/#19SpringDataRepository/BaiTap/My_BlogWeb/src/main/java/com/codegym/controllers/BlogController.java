package com.codegym.controllers;

import com.codegym.models.Blog;
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

    @GetMapping("/createBlog")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("allCategory", categoryService.getAllCategory());
        return "createBlog";
    }

    @PostMapping("/creatingBlog")
    public String creatingBlog(Model model, @ModelAttribute Blog blog) {
        blogService.createBlog(blog);
        model.addAttribute("message", "create successful!");
        model.addAttribute("blog", new Blog());
        model.addAttribute("allCategory", categoryService.getAllCategory());
        return "createBlog";
    }

    @GetMapping("/viewPost")
    public String viewPost(@RequestParam Integer id,
                           @RequestParam(value = "page", defaultValue = "1") String page,
                           @RequestParam Optional<String> keyWord,
                           Model model) {

        try {
            Integer.parseInt(page);
        } catch (Exception e) {
        }

        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);
        Page<Blog> blogPage = null;

        if (keyWord.isPresent()) {
            if (!keyWord.get().equals("")) {
                blogPage = blogService.getBlogByIdCategoryAndKeyWork(keyWord.get(), id, pageable);
                model.addAttribute("posts", blogPage);
                model.addAttribute("keyWord", keyWord.get());
                model.addAttribute("message", "result for keyword : " + keyWord.get());
            }else {
                blogPage = blogService.getBlogByIdCategory(id, pageable);
                model.addAttribute("posts", blogPage);
            }
        } else {
            blogPage = blogService.getBlogByIdCategory(id, pageable);
            model.addAttribute("posts", blogPage);
        }
        model.addAttribute("id", id);
        return "viewAllPostWithCategoryId";
    }

    @GetMapping("/deletePost")
    public String deleteBlog(@RequestParam Integer id) {
        blogService.deleteBlog(id);
        return "redirect:/";
    }

    @GetMapping("/editPost")
    public String editBlog(@RequestParam Integer id, Model model) {
        Optional<Blog> blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog.get());
        return "editPost";
    }

    @PostMapping("/editingPost")
    public String editingCategory(@ModelAttribute Blog blog) {
        blogService.editPost(blog);
        return "redirect:/";
    }

    @GetMapping("/viewContent")
    public String viewContent(@RequestParam Integer id, Model model) {
        Optional<Blog> blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog.get());
        return "viewPost";
    }

}
