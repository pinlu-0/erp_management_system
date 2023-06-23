package com.aaa.controller;

import com.aaa.model.Depot;
import com.aaa.model.Operator;
import com.aaa.service.DepotService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DepotController {
    @Autowired
    DepotService depotService;
    @RequestMapping("/all")
    public String all(Model model, Depot depot){
        List<Depot> all = depotService.all(depot);
        model.addAttribute("depts",all);
        model.addAttribute("de",depot);
        List<Operator> opall = depotService.opall();
        model.addAttribute("opall",opall);
        return "Depots";
    }
    @RequestMapping("/add")
    public String add(Depot depot){
        System.out.println(depot);
        depotService.add(depot);
        return "redirect:/dept/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        depotService.del(id);
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id){
        Depot selectbyid = depotService.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Depot depot){
        depotService.upd(depot);
        return "redirect:/dept/all";
    }

    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        depotService.batchDel(ids);
        return "ok";
    }
}
