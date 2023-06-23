package com.aaa.controller;

import com.aaa.model.*;
import com.aaa.service.Sale_order_itemsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Sale_order_items")
public class Sale_order_itemsController {
    @Autowired
    Sale_order_itemsService service;
    @RequestMapping("/all")
    public String all(Model model, Sale_order_items sale_order_items){
        List<Sale_order_items> all = service.all(sale_order_items);
        model.addAttribute("sale_order_items",all);
        model.addAttribute("sale_order_item",sale_order_items);
        List<Sale_order> oall = service.soall();
        model.addAttribute("sale_orde",oall);
        List<Commodity> call = service.call();
        model.addAttribute("comm",call);
        List<Depot> depoall = service.depoall();
        model.addAttribute("depots",depoall);
        return "Sale_order_items";
    }

    @RequestMapping("/add")
    public String add(Sale_order_items sale_order_items){
        service.add(sale_order_items);
        return "redirect:/Sale_order_items/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        service.del(id);
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id, Model model){
        Sale_order_items selectbyid = service.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);

        return json;
    }
    @RequestMapping("/upd")
    public String upd(Sale_order_items sale_order_items){
        service.upd(sale_order_items);
        return "redirect:/Sale_order_items/all";
    }
    @RequestMapping("/shenhe")
    public String shenhe(Sale_order_items sale_order_items){
        service.shenhe(sale_order_items);
        if(sale_order_items.getSoi_state()==0){
            service.addupsotck(sale_order_items);
        }else if(sale_order_items.getSoi_state()==1){
            service.upsotck(sale_order_items);
        }else if(sale_order_items.getSoi_state()==2){
            service.addupsotck(sale_order_items);
        }
        return "redirect:/Sale_order_items/all";
    }
    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        service.batchDel(ids);
        return "ok";
    }
}

