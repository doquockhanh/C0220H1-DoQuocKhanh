package com.codegym.controllers.furamaService;

import com.codegym.models.rentalService.Room;
import com.codegym.services.furamaService.RoomService;
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
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/addRoom")
    public String addRoom(Model model){
        model.addAttribute("room", new Room());
        return "addService/addRoom";
    }

    @PostMapping("/addingRoom")
    public String addingRoom(@ModelAttribute Room room, Model model){
        roomService.saveRoom(room);
        model.addAttribute("room", new Room());
        model.addAttribute("message", "add successful !");
        return "addService/addRoom";
    }

    @GetMapping("/allRoom")
    public String allRoom(@RequestParam(value = "page", defaultValue = "1") String page, Model model){
        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);
        Page<Room> roomPage = roomService.getAllRoomPaging(pageable);

        model.addAttribute("allRoom", roomPage);
        return "";
    }

    @GetMapping("/deleteRoom")
    public String deleteHouse(@RequestParam String id) {
        roomService.deleteRoomById(id);
        return "";
    }

    @GetMapping("/editRoom")
    public String editRoom(@RequestParam String id, Model model){
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "";
    }
}
