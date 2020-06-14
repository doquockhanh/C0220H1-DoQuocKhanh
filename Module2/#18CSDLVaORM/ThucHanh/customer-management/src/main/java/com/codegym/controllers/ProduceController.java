package com.codegym.controllers;

import com.codegym.models.Produce;
import com.codegym.services.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProduceController {

    @Autowired
    ProduceService produceService;

    @GetMapping("/")
    public String home(Model model) {
        List<Produce> produceList = produceService.getAll();
        model.addAttribute("produces", produceList);
        return "home";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Integer id) {
        Produce editProduce = produceService.getByIdProduce(id);
        model.addAttribute("id", editProduce.getId());
        model.addAttribute("name", editProduce.getName());
        model.addAttribute("price", editProduce.getPrice());
        return "edit";
    }

    @GetMapping("editing")
    public String editing(Model model, @RequestParam Integer id, @RequestParam String name, @RequestParam String price) {
        produceService.editProduce(id, name, price);
        List<Produce> produceList = produceService.getAll();
        model.addAttribute("produces", produceList);
        return "home";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam Integer id) {
        produceService.deleteProduce(id);
        List<Produce> produceList = produceService.getAll();
        model.addAttribute("produces", produceList);
        return "home";
    }

    @GetMapping("/add")
    public String add(Model model, @RequestParam String name, @RequestParam String price) {
        produceService.addProduce(new Produce(name, price));
        List<Produce> produceList = produceService.getAll();
        model.addAttribute("produces", produceList);
        return "home";
    }
}