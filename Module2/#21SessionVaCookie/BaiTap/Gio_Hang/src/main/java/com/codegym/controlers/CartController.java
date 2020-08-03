package com.codegym.controlers;

import com.codegym.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {
    @PostMapping("/addToCart")
    public String addProductToCard(@ModelAttribute Product product, Model model,
                                   @SessionAttribute("productList") List<Product> productList){
        productList.add(product);
        model.addAttribute("productList", productList);
        return "cart";
    }

    @GetMapping("/gotoCart")
    public String gotoCard(Model model,
                           @SessionAttribute("productList") List<Product> productList){
        model.addAttribute("productList", productList);
        return "cart";
    }
}
