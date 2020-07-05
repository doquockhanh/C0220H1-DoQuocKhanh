package com.codegym.controllers;

import com.codegym.models.Category;
import com.codegym.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class Main {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String returnHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(@RequestParam(value = "page", defaultValue = "1") String page, Model model,
                       @RequestParam Optional<String> keyWord) {

        try {
            Integer.parseInt(page);
        } catch (Exception e) {
        }

        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);
        Page<Category> categoryPage = null;

        if (keyWord.isPresent()) {
            if(!keyWord.get().isEmpty()) {
                categoryPage = categoryService.getAllCategoryPagingByKeyWord(keyWord.get(), pageable);
                model.addAttribute("categories", categoryPage);
                model.addAttribute("keyWord", keyWord.get());
                model.addAttribute("message", "result for keyword : " + keyWord.get());
            }else {
                categoryPage = categoryService.getAllCategoryPaging(pageable);
                model.addAttribute("categories", categoryPage);
            }
        } else {
            categoryPage = categoryService.getAllCategoryPaging(pageable);
            model.addAttribute("categories", categoryPage);
        }
        return "homePage";
    }
}
