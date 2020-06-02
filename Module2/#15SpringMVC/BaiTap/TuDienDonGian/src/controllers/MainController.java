package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.FindWord;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class MainController {
    @Autowired
    FindWord findWord;

    @PostMapping("/translate")
    public String translate(@RequestParam String found, Model model){
        model.addAttribute("word", findWord.find(found));
        return "result";
    }
}
