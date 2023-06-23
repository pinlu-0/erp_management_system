package com.aaa.controller;

import com.aaa.model.Client;
import com.aaa.model.Operator;
import com.aaa.model.Sale_order;
import com.aaa.service.Sale_orderService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Sale_order")
public class Sale_orderController {
    @Autowired
    Sale_orderService service;
    @RequestMapping("/all")
    public String all(Model model, Sale_order sale_order){
        List<Sale_order> all = service.all(sale_order);
        model.addAttribute("sale_orders",all);
        model.addAttribute("sale_order",sale_order);
        List<Operator> opall =service.opall();
        model.addAttribute("op",opall);
        List<Client> clall = service.clall();
        model.addAttribute("cl",clall);
        return "Sale_orders";
    }
    @RequestMapping("/add")
    public String add(Sale_order sale_order){
        service.add(sale_order);
        return "redirect:/Sale_order/all";
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
        Sale_order selectbyid = service.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Sale_order sale_order){
        service.upd(sale_order);
        return "redirect:/Sale_order/all";
    }

    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        service.batchDel(ids);
        return "ok";
    }
}
