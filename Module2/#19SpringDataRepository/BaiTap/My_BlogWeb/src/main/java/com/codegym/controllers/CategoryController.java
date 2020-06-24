package com.codegym.controllers;

import com.codegym.models.Category;
import com.codegym.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/createCategory")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @PostMapping("/creatingCategory")
    public String creatingCategory(Model model, @ModelAttribute Category category){

        categoryService.createCategory(category);

        model.addAttribute("message", "create successful!");
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam Integer id){
        categoryService.deleteCategory(id);
        return "redirect:/";
    }

    @GetMapping("/editCategory")
    public String editCategory(@RequestParam Integer id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        model.addAttribute("category", category.get());
        return "editCategory";
    }

    @PostMapping("/editingCategory")
    public String editingCategory(@ModelAttribute Category category){
        categoryService.saveCategory(category);
        return "redirect:/";
    }
}
