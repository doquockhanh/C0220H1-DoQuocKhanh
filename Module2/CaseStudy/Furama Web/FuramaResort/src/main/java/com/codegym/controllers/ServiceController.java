package com.codegym.controllers;

import com.codegym.models.rentalService.Villa;
import com.codegym.services.VillaService;
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

@Controller
public class ServiceController {

    @Autowired
    VillaService villaService;

    @GetMapping("/home")
    public String home(@RequestParam(value = "page", defaultValue = "1") String page, Model model){

        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);

        Page<Villa> villaPage = villaService.getAllVilla(pageable);

        model.addAttribute("allVilla", villaPage);
        return "home";
    }

    @GetMapping("/addVilla")
    public String addVilla(Model model){
        model.addAttribute("villa", new Villa());
        return "addService/addVilla";
    }

    @PostMapping("/addingVilla")
    public String addingVilla(@ModelAttribute Villa villa, Model model){
        villaService.saveVilla(villa);
        model.addAttribute("villa", new Villa());
        model.addAttribute("message", "add successful !");
        return "addService/addVilla";
    }

}
