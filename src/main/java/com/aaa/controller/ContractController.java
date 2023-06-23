package com.aaa.controller;

import com.aaa.model.Commodity;
import com.aaa.model.Contract;
import com.aaa.model.Suppliers;
import com.aaa.service.ContractService;
import com.aaa.until.BaseController;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Contract")
public class ContractController extends BaseController {
    @Autowired
    ContractService contractService;
    @RequestMapping("/all")
    public String all(Model model, Contract contract){
        List<Contract> all = contractService.all(contract);
        model.addAttribute("contract",all);
        model.addAttribute("con",contract);
        List<Suppliers> suall =contractService.suall();
        model.addAttribute("su",suall);
        List<Commodity> commodities=contractService.coall();
        model.addAttribute("com",commodities);
        return "Contracts";
    }
    @RequestMapping("/add")
    public String add( Contract contract){
        contractService.add(contract);
        return "redirect:/Contract/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        contractService.del(id);
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id){
        Contract selectbyid = contractService.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd( Contract contract){
        contractService.upd(contract);
        return "redirect:/Contract/all";
    }

}
