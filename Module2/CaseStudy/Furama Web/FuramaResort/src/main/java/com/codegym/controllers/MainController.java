package com.codegym.controllers;

import com.codegym.models.rentalService.House;
import com.codegym.models.rentalService.Room;
import com.codegym.models.rentalService.Villa;
import com.codegym.services.furamaService.HouseService;
import com.codegym.services.furamaService.RoomService;
import com.codegym.services.furamaService.VillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    VillaService villaService;

    @Autowired
    HouseService houseService;

    @Autowired
    RoomService roomService;

    private String serviceSelect = "villa";

    @GetMapping("/")
    public String returnHome(Model model, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("service", "villa");
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(@RequestParam(value = "page", defaultValue = "1") String page,
                       @RequestParam Optional<String> service,
                       Model model){
        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);

        if(service.isPresent()){
            serviceSelect = service.get();
        }

        if(serviceSelect.equals("villa")) {
            Page<Villa> villaPage = villaService.getAllVilla(pageable);
            model.addAttribute("allService", villaPage);
        }else if(serviceSelect.equals("house")){
            Page<House> housePage = houseService.getAllHousePaging(pageable);
            model.addAttribute("allService", housePage);
        }else if(serviceSelect.equals("room")){
            Page<Room> roomPage = roomService.getAllRoomPaging(pageable);
            model.addAttribute("allService", roomPage);
        }
        return "home";
    }
}
