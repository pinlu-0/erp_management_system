package com.aaa.controller;

import com.aaa.model.Operator;
import com.aaa.model.Suppliers;
import com.aaa.service.SuppliersService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Suppliers")
public class SuppliersController {
    @Autowired
    SuppliersService suppliersService;
    @RequestMapping("/all")
    public String all(Model model, Suppliers suppliers){
        List<Suppliers> all = suppliersService.all(suppliers);
        model.addAttribute("supll",all);
        model.addAttribute("su",suppliers);
        List<Operator> opall = suppliersService.opall();
        model.addAttribute("op",opall);
        return "Suppliers";
    }
    @RequestMapping("/add")
    public String add(Suppliers suppliers){
        suppliersService.add(suppliers);
        return "redirect:/Suppliers/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        suppliersService.del(id);
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id){
        Suppliers selectbyid = suppliersService.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Suppliers suppliers){
        suppliersService.upd(suppliers);
        return "redirect:/Suppliers/all";
    }

    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        suppliersService.batchDel(ids);
        return "ok";
    }
}

