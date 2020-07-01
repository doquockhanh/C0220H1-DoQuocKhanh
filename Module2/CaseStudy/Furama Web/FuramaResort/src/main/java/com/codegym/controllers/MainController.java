package com.codegym.controllers;

import com.codegym.models.rentalService.Villa;
import com.codegym.services.furamaService.VillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    VillaService villaService;

    @GetMapping("/")
    public String returnHome(){
         return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(@RequestParam(value = "page", defaultValue = "1") String page, Model model){

        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);

        Page<Villa> villaPage = villaService.getAllVilla(pageable);

        model.addAttribute("allVilla", villaPage);
        return "home";
    }
}
