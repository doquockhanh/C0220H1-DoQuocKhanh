package com.codegym.controllers.employee;

import com.codegym.models.employee.Employee;
import com.codegym.services.employee.DepartmentService;
import com.codegym.services.employee.EmployeeService;
import com.codegym.services.employee.LiteracyService;
import com.codegym.services.employee.PositionService;
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
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    LiteracyService literacyService;

    @Autowired
    PositionService positionService;

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartment());
        model.addAttribute("literacy", literacyService.getAllLiteracy());
        model.addAttribute("positions", positionService.getAllPosition());
        return "employee/employee/addEmployee";
    }

    @PostMapping("/addingEmployee")
    public String addingEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model){
        new Employee().validate(employee, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "employee/employee/addEmployee";
        }

        employeeService.saveEmployee(employee);
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartment());
        model.addAttribute("literacy", literacyService.getAllLiteracy());
        model.addAttribute("positions", positionService.getAllPosition());
        model.addAttribute("message", "add successful !");
        return "employee/employee/addEmployee";
    }

    @GetMapping("/allEmployee")
    public String allEmployee(@RequestParam(value = "page", defaultValue = "1") String page, Model model){
        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 6);
        Page<Employee> employeePage = employeeService.getAllEmployee(pageable);

        model.addAttribute("allEmployee", employeePage);
        return "employee/employee/allEmployee";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam String id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/allEmployee";
    }

    @GetMapping("/editEmployee")
    public String editEmployee(@RequestParam String id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartment());
        model.addAttribute("literacy", literacyService.getAllLiteracy());
        model.addAttribute("positions", positionService.getAllPosition());
        return "employee/employee/editEmployee";
    }

    @PostMapping("/editingEmployee")
    public String editingEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, Model model){
        new Employee().validate(employee, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("departments", departmentService.getAllDepartment());
            model.addAttribute("literacy", literacyService.getAllLiteracy());
            model.addAttribute("positions", positionService.getAllPosition());
            return "employee/employee/editEmployee";
        }

        employeeService.editEmployee(employee);
        model.addAttribute("message", "saved your change!");
        return "redirect:/allEmployee";
    }
}
