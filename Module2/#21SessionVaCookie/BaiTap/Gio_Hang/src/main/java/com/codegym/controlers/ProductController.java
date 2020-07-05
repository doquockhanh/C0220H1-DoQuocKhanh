package com.codegym.controlers;

import com.codegym.models.Product;
import com.codegym.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("productList")
public class ProductController {

    private static List<Product> productList = new ArrayList<>();

    @Autowired
    ProductService productService;

    @ModelAttribute("productList")
    public List<Product> product(){
        return productList;
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
        Optional<Product> product = productService.getById(id);
        model.addAttribute("product", product.get());
        return "productInfo";
    }
}
