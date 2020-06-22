package com.codegym.controlers;

import com.codegym.models.Product;
import com.codegym.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @ModelAttribute("product")
    public Product product(){
        return new Product();
    }

    @GetMapping("/")
    public String goHome(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/productInfo")
    public String productInfo(Model model, @RequestParam Integer id){
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "productInfo";
    }

    @PostMapping("/addToCard")
    public String addProductToCard(@ModelAttribute("product") Product product){
        return "card";
    }

    @GetMapping("/gotoCard")
    public String gotoCard(){
        return "card";
    }
}
