package com.codegym.controllers.contract;

import com.codegym.models.contract.ContractDetail;
import com.codegym.services.contract.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ContractDetailController {

    @Autowired
    ContractDetailService contractDetailService;

    @GetMapping("/addContractDetail")
    public String addContractDetail(Model model){
        model.addAttribute("contractDetail", new ContractDetail());
        return "";
    }

    @PostMapping("/addingContractDetail")
    public String addingContractDetail(@ModelAttribute ContractDetail contractDetail, Model model){
        contractDetailService.saveContractDetail(contractDetail);
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("message", "add successful !");
        return "";
    }

    @GetMapping("/getAllContractDetail")
    public String getAllContractDetail(Model model){
        List<ContractDetail> contractDetailList = contractDetailService.getAllContractDetail();
        model.addAttribute("contractDetails", contractDetailList);
        return "";
    }

    @GetMapping("/getContractDetail")
    public String getContractDetailById(@RequestParam Integer id, Model model){
        ContractDetail contractDetail = contractDetailService.getContractDetailById(id);
        model.addAttribute("contractDetail", contractDetail);
        return "";
    }

    @GetMapping("/deleteContractDetail")
    public String deleteContractDetail(@RequestParam Integer id){
        contractDetailService.deleteContractDetailById(id);
        return "";
    }
}
