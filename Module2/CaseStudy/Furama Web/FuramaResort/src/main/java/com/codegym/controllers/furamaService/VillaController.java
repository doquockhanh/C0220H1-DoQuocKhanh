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
        return "addService/addVilla";
    }

    @PostMapping("/addingVilla")
    public String addingVilla(@ModelAttribute Villa villa, Model model){
        villaService.saveVilla(villa);
        model.addAttribute("villa", new Villa());
        model.addAttribute("message", "add successful !");
        return "addService/addVilla";
    }

    @GetMapping("/allVilla")
    public String allVilla(@RequestParam(value = "page", defaultValue = "1") String page, Model model){
        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);
        Page<Villa> VillaPage = villaService.getAllVilla(pageable);

        model.addAttribute("allVilla", VillaPage);
        return "";
    }

    @GetMapping("/deleteVilla")
    public String deleteVilla(@RequestParam String id) {
        villaService.deleteVillaById(id);
        return "";
    }

    @GetMapping("/editVilla")
    public String editVilla(@RequestParam String id, Model model){
        Villa villa = villaService.getVillaById(id);
        model.addAttribute("villa", villa);
        return "";
    }

}
