package com.codegym.controllers.contract;

import com.codegym.models.contract.Contract;
import com.codegym.services.contract.ContractService;
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

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

@Controller
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping("/addContract")
    public String addContract(Model model){
        model.addAttribute("contract", new Contract());
        return "contract/contract/addContract";
    }

    @PostMapping("/addingContract")
    public String addingHouse(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, Model model){
        new Contract().validate(contract, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "contract/contract/addContract";
        }

        contractService.saveContract(contract);
        model.addAttribute("contract", new Contract());
        model.addAttribute("message", "add successful !");
        return "contract/contract/addContract";
    }

    @GetMapping("/getAllContract")
    public String getAllContract(Model model, @RequestParam(defaultValue = "1") String page){

        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 6);

        Page<Contract> contractPage = contractService.getAllContract(pageable);
        model.addAttribute("contracts", contractPage);
        return "contract/contract/allContract";
    }

    @GetMapping("/getContract")
    public String getContractById(@RequestParam String id, Model model){
        Contract contract = contractService.getContractById(id);
        model.addAttribute("contract", contract);
        return "";
    }

    @GetMapping("/deleteContract")
    public String deleteContract(@RequestParam String id){
        contractService.deleteContractById(id);
        return "redirect:/getAllContract";
    }

    @GetMapping("/editContract")
    public String editContract(@RequestParam String id, Model model){
        Contract contract = contractService.getContractById(id);
        model.addAttribute("contract", contract);
        return "contract/contract/editContract";
    }

    @PostMapping("/editingContract")
    public String editingContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, Model model){
        new Contract().validate(contract, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "contract/contract/editContract";
        }

        contractService.saveContract(contract);
        model.addAttribute("contract", new Contract());
        model.addAttribute("message", "saved your change!");
        return "redirect:/getAllContract";
    }
}
