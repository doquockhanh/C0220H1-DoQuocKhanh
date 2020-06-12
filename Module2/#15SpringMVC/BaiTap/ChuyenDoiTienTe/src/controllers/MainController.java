package controllers;

import Service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    ConvertService convertService;

    @PostMapping("result")
    public String convert(@RequestParam String inputValue, @RequestParam String typeConvert,  Model model){
        model.addAttribute("value", inputValue);
        model.addAttribute("rate", typeConvert);
        model.addAttribute("result", convertService.convert(Long.parseLong(inputValue), Integer.parseInt(typeConvert)));
        return "index";
    }
}
