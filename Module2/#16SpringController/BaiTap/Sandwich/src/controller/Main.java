package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Optional;

@Controller
public class Main {

    @PostMapping("save")
    public String save(Model model, @RequestParam  Optional<String[]> condiments) {
        if(condiments.isPresent()) {
            model.addAttribute("result", Arrays.toString(condiments.get()));
        }
        return "index";
    }
}
