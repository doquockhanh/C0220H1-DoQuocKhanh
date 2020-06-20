package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String returnHome(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
