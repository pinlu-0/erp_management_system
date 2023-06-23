package com.aaa.controller;

import com.aaa.model.Erp_role;
import com.aaa.service.Erp_roleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Erp_role")
public class Erp_roleControlle {
    @Autowired
    Erp_roleService service;
    @RequestMapping("/all")
    public String all(Model model, Erp_role erp_role){
        List<Erp_role> all = service.all(erp_role);
        model.addAttribute("erp_roles",all);
        model.addAttribute("erp_role",erp_role);
        return "Erp_roles";
    }
    @RequestMapping("/add")
    public String add(Erp_role erp_role){
        service.add(erp_role);
        return "redirect:/Erp_role/all";
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
        Erp_role selectbyid = service.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Erp_role erp_role){
        service.upd(erp_role);
        return "redirect:/Erp_role/all";
    }


}