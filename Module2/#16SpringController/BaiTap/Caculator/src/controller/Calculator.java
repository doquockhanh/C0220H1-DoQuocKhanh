package controller;

import model.CalculateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class Calculator {

    @Autowired
    private CalculateModel calculateModel;

    @GetMapping
    public String PersonalCalculator(@RequestParam String firstNum,
                                     @RequestParam String secondNum,
                                     @RequestParam String operator,
                                     Model model){
        model.addAttribute("firstNum", firstNum);
        model.addAttribute("secondNum", secondNum);
        model.addAttribute("operator", operator);
        if (operator.equals("add")){
            model.addAttribute("result", calculateModel.add(Integer.parseInt(firstNum), Integer.parseInt(secondNum)));
        }else if(operator.equals("sub")){
            model.addAttribute("result", calculateModel.sub(Integer.parseInt(firstNum), Integer.parseInt(secondNum)));
        }else if(operator.equals("mul")){
            model.addAttribute("result", calculateModel.mul(Integer.parseInt(firstNum), Integer.parseInt(secondNum)));
        }else {
            model.addAttribute("result", calculateModel.div(Integer.parseInt(firstNum), Integer.parseInt(secondNum)));
        }

        return "index";
    }

}
