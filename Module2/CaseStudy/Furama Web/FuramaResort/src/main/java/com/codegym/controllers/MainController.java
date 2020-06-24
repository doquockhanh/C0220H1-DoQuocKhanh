package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String returnHome(){
         return "redirect:/home";
    }

    // todo: commit từng file vào git
    // đã tạo được bảng villa
    // đã add được villa
    // todo: thêm validate cho villa
    // todo: hiển thị đầy đủ thuộc tính villa ở home

}
