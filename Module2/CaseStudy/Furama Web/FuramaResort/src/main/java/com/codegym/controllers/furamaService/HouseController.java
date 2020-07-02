package com.codegym.controllers.furamaService;

import com.codegym.models.rentalService.House;
import com.codegym.services.furamaService.HouseService;
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

import java.util.List;

@Controller
public class HouseController {

    @Autowired
    HouseService houseService;

    @GetMapping("/addHouse")
    public String addHouse(Model model){
        model.addAttribute("house", new House());
        return "service/house/addHouse";
    }

    @PostMapping("/addingHouse")
    public String addingHouse(@ModelAttribute House house, Model model){
        houseService.saveHouse(house);
        model.addAttribute("house", new House());
        model.addAttribute("message", "add successful !");
        return "service/house/addHouse";
    }

    @GetMapping("/allHouse")
    public String allHouse(@RequestParam(value = "page", defaultValue = "1") String page, Model model){
        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);
        Page<House> housePage = houseService.getAllHousePaging(pageable);

        model.addAttribute("allHouse", housePage);
        return "service/house/allHouse";
    }

    @GetMapping("/deleteHouse")
    public String deleteHouse(@RequestParam String id) {
        houseService.deleteHouseById(id);
        return "redirect:/allHouse";
    }

    @GetMapping("/editHouse")
    public String editHouse(@RequestParam String id, Model model){
        House house = houseService.getHouseById(id);
        model.addAttribute("house", house);
        return "service/house/editHouse";
    }

    @PostMapping("/editingHouse")
    public String editingTypeCustomer(@ModelAttribute House house, Model model){
        houseService.editHouse(house);
        model.addAttribute("message", "saved your change!");
        return "redirect:/allHouse";
    }
}
