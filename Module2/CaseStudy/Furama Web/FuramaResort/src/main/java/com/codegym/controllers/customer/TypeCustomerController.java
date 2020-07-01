package com.codegym.controllers.customer;

import com.codegym.models.customer.TypeCustomer;
import com.codegym.services.customer.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeCustomerController {

    @Autowired
    TypeCustomerService typeCustomerService;

    @GetMapping("/allTypeCustomer")
    public String allTypeCustomer(Model model) {
        List<TypeCustomer> typeCustomerList = typeCustomerService.getAllTypeCustomer();
        model.addAttribute("typeCustomers", typeCustomerList);
        return "customer/typeCustomer";
    }

    @GetMapping("/deleteTypeCustomer")
    public String deleteTypeCustomer(@RequestParam Integer id) {
        typeCustomerService.deleteTypeCustomer(id);
        return "redirect:/allTypeCustomer";
    }

    @GetMapping("/editTypeCustomer")
    public String editTypeCustomer(@RequestParam Integer id, Model model){
        TypeCustomer typeCustomer = typeCustomerService.getTypeCustomerById(id);
        model.addAttribute("typeCustomer", typeCustomer);
        return "editTypeCustomer";
    }

    @PostMapping("/editingTypeCustomer")
    public String editingTypeCustomer(@ModelAttribute TypeCustomer typeCustomer){
        typeCustomerService.saveTypeCustomer(typeCustomer);
        return "redirect:/allTypeCustomer";
    }

    @GetMapping("/addTypeCustomer")
    public String addTypeCustomer(Model model) {
        model.addAttribute("typeCus", new TypeCustomer());
        return "customer/addTypeCustomer";
    }

    @PostMapping("/addingTypeCustomer")
    public String addingTypeCustomer(Model model, @ModelAttribute TypeCustomer typeCustomer) {
        typeCustomerService.saveTypeCustomer(typeCustomer);
        model.addAttribute("typeCus", new TypeCustomer());
        model.addAttribute("message", "add successful");
        return "customer/addTypeCustomer";
    }
}
