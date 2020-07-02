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
        return "service/room/addRoom";
    }

    @PostMapping("/addingRoom")
    public String addingRoom(@ModelAttribute Room room, Model model){
        roomService.saveRoom(room);
        model.addAttribute("room", new Room());
        model.addAttribute("message", "add successful !");
        return "service/room/addRoom";
    }

    @GetMapping("/allRoom")
    public String allRoom(@RequestParam(value = "page", defaultValue = "1") String page, Model model){
        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);
        Page<Room> roomPage = roomService.getAllRoomPaging(pageable);

        model.addAttribute("allRoom", roomPage);
        return "service/room/allRoom";
    }

    @GetMapping("/deleteRoom")
    public String deleteHouse(@RequestParam String id) {
        roomService.deleteRoomById(id);

        return "redirect:/allRoom";
    }

    @GetMapping("/editRoom")
    public String editRoom(@RequestParam String id, Model model){
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "service/room/editRoom";
    }

    @PostMapping("/editingRoom")
    public String editingVilla(@ModelAttribute Room room, Model model){
        roomService.editRoom(room);
        model.addAttribute("message", "saved your change!");
        return "redirect:/allRoom";
    }
}
