package com.codegym.controllers.contract;

import com.codegym.models.contract.Contract;
import com.codegym.services.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping("/addContract")
    public String addContract(Model model){
        model.addAttribute("contract", new Contract());
        return "addContract";
    }

    @PostMapping("/addingContract")
    public String addingHouse(@ModelAttribute Contract contract, Model model){
        contractService.saveContract(contract);
        model.addAttribute("contract", new Contract());
        model.addAttribute("message", "add successful !");
        return "addContract";
    }

    @GetMapping("/getAllContract")
    public String getAllContract(Model model, @RequestParam(defaultValue = "1") String page){

        Pageable pageable = PageRequest.of(Integer.parseInt(page) - 1, 2);

        Page<Contract> contractPage = contractService.getAllContract(pageable);
        model.addAttribute("contracts", contractPage);
        return "";
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
        return "";
    }
}
