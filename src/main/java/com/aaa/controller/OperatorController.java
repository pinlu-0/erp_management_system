package com.aaa.controller;

import com.aaa.model.Operator;
import com.aaa.service.OperatorService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/Operator")
@Controller
public class OperatorController {
    @Autowired
    OperatorService operatorService;
    @RequestMapping("/all")
    public String all(Model model, Operator operator){
        List<Operator> all = operatorService.all(operator);
        model.addAttribute("operat",all);
        model.addAttribute("op",operator);
        return "Operator";
    }
    @RequestMapping("/add")
    public String add(Operator operator){
        operatorService.add(operator);
        return "redirect:/Operator/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        operatorService.del(id);
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id){
        Operator selectbyid = operatorService.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Operator operator){
        operatorService.upd(operator);
        return "redirect:/Operator/all";
    }

    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        operatorService.batchDel(ids);
        return "ok";
    }
}
