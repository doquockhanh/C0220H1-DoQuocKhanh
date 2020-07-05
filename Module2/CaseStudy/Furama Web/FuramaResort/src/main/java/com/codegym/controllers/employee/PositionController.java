package com.codegym.controllers.employee;

import com.codegym.models.employee.Position;
import com.codegym.services.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("/addPosition")
    public String addPosition(Model model){
        model.addAttribute("position", new Position());
        return "employee/position/addPosition";
    }

    @PostMapping("/addingPosition")
    public String addingPosition(@ModelAttribute Position position, Model model){
        positionService.savePosition(position);
        model.addAttribute("position", new Position());
        model.addAttribute("message", "add successful !");
        return "employee/position/addPosition";
    }

    @GetMapping("/allPosition")
    public String allPosition(Model model){
        List<Position> positionList= positionService.getAllPosition();
        model.addAttribute("positionList", positionList);
        return "employee/position/allPosition";
    }

    @GetMapping("/deletePosition")
    public String deletePosition(@RequestParam Integer id) {
        positionService.deletePosition(id);
        return "redirect:/allPosition";
    }

    @GetMapping("/editPosition")
    public String editPosition(@RequestParam Integer id, Model model){
        Position position = positionService.getPositionById(id);
        model.addAttribute("position", position);
        return "employee/position/editPosition";
    }

    @PostMapping("/editingPosition")
    public String editingPosition(@ModelAttribute Position position, Model model) {
        positionService.editPosition(position);
        model.addAttribute("message", "saved your change!");
        return "redirect:/allPosition";
    }
}
