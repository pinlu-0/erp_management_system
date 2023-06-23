package com.aaa.controller;

import com.aaa.model.Operator;
import com.aaa.model.Orde;
import com.aaa.model.Suppliers;
import com.aaa.service.OrdeService;
import com.aaa.until.BaseController;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Orde")
public class OrderController extends BaseController {
    @Autowired
    OrdeService service;
    @RequestMapping("/all")
    public String all(Model model, Orde orde){
        List<Orde> all = service.all(orde);
        model.addAttribute("ordes",all);
        model.addAttribute("orde",orde);
        List<Operator> opall =service.opall();
        model.addAttribute("op",opall);
        List<Suppliers> suall = service.suall();
        model.addAttribute("su",suall);
        return "Ordes";
    }
    @RequestMapping("/add")
    public String add(Orde orde){
        service.add(orde);
        return "redirect:/Orde/all";
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
        Orde selectbyid = service.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Orde orde){
        service.upd(orde);
        return "redirect:/Orde/all";
    }

    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        service.batchDel(ids);
        return "ok";
    }
}

