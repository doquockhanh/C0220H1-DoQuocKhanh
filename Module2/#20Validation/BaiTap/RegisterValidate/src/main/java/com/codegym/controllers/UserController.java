package com.codegym.controllers;

import com.codegym.models.User;
import com.codegym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        User user = new User();
        user.setOld(17);
        model.addAttribute("user",user);
        return "home";
    }

    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute User user, BindingResult bindingResult) {

        new User().validate(user, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "home";
        }

        userService.saveUser(user);

        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        return "listUser";
    }
}
