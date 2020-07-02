package com.codegym.controllers.furamaService;

import com.codegym.models.rentalService.Villa;
import com.codegym.services.furamaService.VillaService;
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
public class VillaController {

    @Autowired
    VillaService villaService;

    @GetMapping("/addVilla")
    public String addVilla(Model model){
        model.addAttribute("villa", new Villa());
        return "service/villa/addVilla";
    }

    @PostMapping("/addingVilla")
    public String addingVilla(@ModelAttribute Villa villa, Model model){
        villaService.saveVilla(villa);
        model.addAttribute("villa", new Villa());
        model.addAttribute("message", "add successful !");
        return "service/villa/addVilla";
    }

    @GetMapping("/allVilla")
    public String allVilla(@RequestParam(value = "page", defaultValue = "1") String page, Model model){
        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 6);
        Page<Villa> VillaPage = villaService.getAllVilla(pageable);

        model.addAttribute("allVilla", VillaPage);
        return "service/villa/allVilla";
    }

    @GetMapping("/deleteVilla")
    public String deleteVilla(@RequestParam String id) {
        villaService.deleteVillaById(id);
        return "redirect:/allVilla";
    }

    @GetMapping("/editVilla")
    public String editVilla(@RequestParam String id, Model model){
        Villa villa = villaService.getVillaById(id);
        model.addAttribute("villa", villa);
        return "service/villa/editVilla";
    }

    @PostMapping("/editingVilla")
    public String editingVilla(@ModelAttribute Villa villa, Model model){
        villaService.editVilla(villa);
        model.addAttribute("message", "saved your change!");
        return "redirect:/allVilla";
    }
}
