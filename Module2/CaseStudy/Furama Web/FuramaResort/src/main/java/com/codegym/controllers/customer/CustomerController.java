package com.codegym.controllers.customer;

import com.codegym.models.customer.Customer;
import com.codegym.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/register";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {

        new Customer().validate(customer, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "customer/register";
        }

        customerService.saveCustomer(customer);
        return "redirect:/home";
    }

    @GetMapping("/getAllCustomer")
    public String getAllCustomer(Model model, @RequestParam(defaultValue = "1") String page){

        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);

        Page<Customer> customerList = customerService.getAllCustomer(pageable);
        model.addAttribute("customers", customerList);
        return "customer/allCustomer";
    }

    @GetMapping("/getCustomer")
    public String getCustomerById(@RequestParam String id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer/customerInformation";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam String id){
        customerService.deleteCustomerById(id);
        return "redirect:/getAllCustomer";
    }

    @GetMapping("/editCustomer")
    public String editCustomer(@RequestParam String id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "redirect:/getAllCustomer";
    }

    @PostMapping("/editingCustomer")
    public String editingCustomer(@ModelAttribute Customer customer, Model model){
        customerService.saveCustomer(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("message", "add successful");
        return "customer/customerInformation";
    }
}
