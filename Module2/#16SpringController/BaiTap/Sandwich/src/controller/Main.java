package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class Main {

    @GetMapping("save")
    public String save(Model model, @RequestParam String[] Condiments) {
        model.addAttribute("items", Arrays.toString(Condiments));
        return "home";
    }
}
