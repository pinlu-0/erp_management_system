package com.aaa.controller;

import com.aaa.model.In_bill;
import com.aaa.model.Operator;
import com.aaa.model.Suppliers;
import com.aaa.service.In_billService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/In_bill")
public class In_billController {
    @Autowired
    In_billService service;
    @RequestMapping("/all")
    public String all(Model model, In_bill in_bill){
        List<In_bill> all=service.all(in_bill);
        model.addAttribute("in_bills",all);
        model.addAttribute("in_bill",in_bill);
        List<Operator> opall =service.opall();
        model.addAttribute("op",opall);
        List<Suppliers> suall = service.suall();
        model.addAttribute("su",suall);
        return "In_bills";
    }
    @RequestMapping("/add")
    public String add(In_bill in_bill){
        service.add(in_bill);
        return "redirect:/In_bill/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        service.del(id);
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id){
        In_bill selectbyid = service.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(In_bill in_bill){
        service.upd(in_bill);
        return "redirect:/In_bill/all";
    }

    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        service.batchDel(ids);
        return "ok";
    }
}
