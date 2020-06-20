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
    private ProduceService produceService;

    @GetMapping("/")
    public String main(Model model) {
        List<Produce> produceList = produceService.getAll();
        model.addAttribute("produceList", produceList);
        return "index";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Integer id){
        Produce editProduce = produceService.findById(id);

        model.addAttribute("id", editProduce.getId());
        model.addAttribute("name", editProduce.getName());
        model.addAttribute("price", editProduce.getPrice());
        return "edit";
    }

    @GetMapping("/editing")
    public String editing(Model model, @RequestParam String id, @RequestParam String name, @RequestParam String price) {
        produceService.editProduce(Integer.parseInt(id), Integer.parseInt(id), name, price);
        List<Produce> produceList = produceService.getAll();
        model.addAttribute("produceList", produceList);
        return "index";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam Integer id){
        produceService.deleteProduce(id);

        List<Produce> produceList = produceService.getAll();
        model.addAttribute("produceList", produceList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model, @RequestParam String id, @RequestParam String name, @RequestParam String price){
        produceService.addProduce(Integer.parseInt(id), Integer.parseInt(id), name, price);
        List<Produce> produceList = produceService.getAll();
        model.addAttribute("produceList", produceList);
        return "index";
    }
}
