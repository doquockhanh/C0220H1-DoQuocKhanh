package com.codegym.controllers.furamaService;

import com.codegym.models.rentalService.AccompaniedService;
import com.codegym.services.furamaService.AccompaniedService_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AccompaniedServiceController {

    @Autowired
    AccompaniedService_Service accompaniedService_service;

    @GetMapping("/addAccompaniedService")
    public String addAccompaniedService(Model model){
        model.addAttribute("accompaniedService", new AccompaniedService());
        return "";
    }

    @PostMapping("/addingAccompaniedService")
    public String addingAccompaniedService(@ModelAttribute AccompaniedService accompaniedService, Model model){
        accompaniedService_service.saveAccompaniedService(accompaniedService);
        model.addAttribute("accompaniedService", new AccompaniedService());
        model.addAttribute("message", "add successful !");
        return "";
    }

    @GetMapping("/allAccompaniedService")
    public String allAccompaniedService(Model model){
        List<AccompaniedService> accompaniedServiceList = accompaniedService_service.getAllAccompaniedService();
        model.addAttribute("accompaniedServices", accompaniedServiceList);
        return "";
    }

    @GetMapping("/deleteAccompaniedService")
    public String deleteAccompaniedService(@RequestParam String id) {
        accompaniedService_service.deleteAccompaniedServiceById(id);
        return "";
    }

    @GetMapping("/editAccompaniedService")
    public String editAccompaniedService(@RequestParam String id, Model model){
        AccompaniedService accompaniedService = accompaniedService_service.getAccompaniedServiceById(id);
        model.addAttribute("accompaniedService", accompaniedService);
        return "";
    }

    @PostMapping("/editingAccompaniedService")
    public String editingAccompaniedService(@ModelAttribute AccompaniedService accompaniedService){
        accompaniedService_service.saveAccompaniedService(accompaniedService);
        return "";
    }
}