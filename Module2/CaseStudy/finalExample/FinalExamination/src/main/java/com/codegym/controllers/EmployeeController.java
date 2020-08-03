package com.codegym.controllers;

import com.codegym.models.Employee;
import com.codegym.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String goHome() {
        return "redirect:/home";
    }

    //list employee
    @GetMapping("/home")
    public String home(Model model, @RequestParam Optional<String> keyWord) {

        List<Employee> employeeList;

        if (keyWord.isPresent() && !keyWord.get().equals("")){
            try {
                employeeList =
                        employeeService.getEmployeeByKeyWord(
                                Integer.parseInt(keyWord.get()),
                                keyWord.get(),
                                keyWord.get()
                        );
                model.addAttribute("employees", employeeList);
            }catch (Exception e){
                employeeList =
                        employeeService.getEmployeeByKeyWord(
                                0,
                                keyWord.get(),
                                keyWord.get()
                        );
                model.addAttribute("employees", employeeList);
            }
        } else {
            employeeList = employeeService.getAllEmployee();
            model.addAttribute("employees", employeeList);
        }
        return "home";
    }

    //goto add employee
    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    //add employee
    @PostMapping("/addingEmployee")
    public String addingEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model) {
        new Employee().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "addEmployee";
        }
        employeeService.addEmployee(employee);
        return "redirect:/home";
    }

    //confirm delete
    @GetMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam Integer id, Model model) {
        model.addAttribute("id", id);
        return "confirmDelete";
    }

    //delete
    @GetMapping("deletingEmployee")
    public String deletingEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/home";
    }
}
