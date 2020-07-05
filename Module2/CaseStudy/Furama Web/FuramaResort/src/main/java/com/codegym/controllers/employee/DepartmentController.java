package com.codegym.controllers.employee;

import com.codegym.models.employee.Department;
import com.codegym.services.employee.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/addDepartment")
    public String addDepartment(Model model){
        model.addAttribute("department", new Department());
        return "employee/department/addDepartment";
    }

    @PostMapping("/addingDepartment")
    public String addingDepartment(@ModelAttribute Department department, Model model){
        departmentService.saveDepartment(department);
        model.addAttribute("department", new Department());
        model.addAttribute("message", "add successful !");
        return "employee/department/addDepartment";
    }

    @GetMapping("/allDepartment")
    public String allDepartment(Model model){
        List<Department> departmentList = departmentService.getAllDepartment();
        model.addAttribute("departments", departmentList);
        return "employee/department/allDepartment";
    }

    @GetMapping("/deleteDepartment")
    public String deleteDepartment(@RequestParam Integer id) {
        departmentService.deleteDepartment(id);
        return "redirect:/allDepartment";
    }

    @GetMapping("/editDepartment")
    public String editDepartment(@RequestParam Integer id, Model model){
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        return "employee/department/editDepartment";
    }

    @PostMapping("/editingDepartment")
    public String editingDepartment(@ModelAttribute Department department, Model model){
        departmentService.editDepartment(department);
        model.addAttribute("message", "saved your change!");
        return "redirect:/allDepartment";
    }
}
