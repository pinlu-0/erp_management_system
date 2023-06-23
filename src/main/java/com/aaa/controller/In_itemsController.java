package com.aaa.controller;

import com.aaa.model.Commodity;
import com.aaa.model.Depot;
import com.aaa.model.In_bill;
import com.aaa.model.In_items;
import com.aaa.service.In_itemsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/In_items")
public class In_itemsController {
    @Autowired
    In_itemsService service;
    @RequestMapping("/all")
    public String all(Model model, In_items in_items){
        List<In_items> all = service.all(in_items);
        model.addAttribute("in_items",all);
        model.addAttribute("in_item",in_items);
        List<Commodity> coall = service.coall();
        model.addAttribute("comm",coall);
        List<In_bill> iball = service.iball();
        model.addAttribute("In_bill",iball);
        List<Depot> depot = service.depot();
        model.addAttribute("depots",depot);
        return "In_items";
    }
    @RequestMapping("/add")
    public String add(In_items in_items){
        service.add(in_items);
        return "redirect:/In_items/all";
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
        In_items selectbyid = service.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(In_items in_items){
        service.upd(in_items);
        return "redirect:/In_items/all";
    }
    @RequestMapping("/shenhe")
    public String shenhe(In_items in_items){
        service.shenhe(in_items);
        if(in_items.getPii_state()==0){
            service.upsotck(in_items);
        }else if(in_items.getPii_state()==1){
            service.addupsotck(in_items);
        }else if(in_items.getPii_state()==2){
            service.upsotck(in_items);
        }
        return "redirect:/In_items/all";
    }
    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        service.batchDel(ids);
        return "ok";
    }
}

