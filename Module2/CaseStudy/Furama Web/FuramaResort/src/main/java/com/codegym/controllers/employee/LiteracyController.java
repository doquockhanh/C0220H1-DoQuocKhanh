package com.codegym.controllers.employee;

import com.codegym.models.employee.Literacy;
import com.codegym.services.employee.LiteracyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LiteracyController {
    @Autowired
    LiteracyService literacyService;

    @GetMapping("/addLiteracy")
    public String addLiteracy(Model model){
        model.addAttribute("literacy", new Literacy());
        return "employee/literacy/addLiteracy";
    }

    @PostMapping("/addingLiteracy")
    public String addingLiteracy(@ModelAttribute Literacy literacy, Model model){
        //method saveLateral sai ten nhung khong sua vi phai copmmit lai :))
        literacyService.saveLateral(literacy);
        model.addAttribute("literacy", new Literacy());
        model.addAttribute("message", "add successful !");
        return "employee/literacy/addLiteracy";
    }

    @GetMapping("/allLiteracy")
    public String allLiteracy(Model model){
        List<Literacy> literacyList= literacyService.getAllLiteracy();
        model.addAttribute("literacyList", literacyList);
        return "employee/literacy/allLiteracy";
    }

    @GetMapping("/deleteLiteracy")
    public String deleteLiteracy(@RequestParam Integer id) {
        literacyService.deleteLiteracy(id);
        return "redirect:/allLiteracy";
    }

    @GetMapping("/editLiteracy")
    public String editLiteracy(@RequestParam Integer id, Model model){
        Literacy literacy = literacyService.getLiteracyById(id);
        model.addAttribute("literacy", literacy);
        return "employee/literacy/editLiteracy";
    }

    @PostMapping("/editingLiteracy")
    public String editingLiteracy(@ModelAttribute Literacy literacy, Model model) {
        literacyService.editLiteracy(literacy);
        model.addAttribute("message", "saved your change!");
        return "redirect:/allLiteracy";
    }
}
