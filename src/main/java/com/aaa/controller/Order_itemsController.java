package com.aaa.controller;

import com.aaa.model.Commodity;
import com.aaa.model.Orde;
import com.aaa.model.Order_items;
import com.aaa.service.Order_itemsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Order_items")
public class Order_itemsController {
    @Autowired
    Order_itemsService service;
    @RequestMapping("/all")
    public String all(Model model, Order_items order_items){
        List<Order_items> all = service.all(order_items);
        model.addAttribute("order_items",all);
        model.addAttribute("oitem",order_items);
        List<Orde> oall = service.oall();
        model.addAttribute("orde",oall);
        List<Commodity> call = service.call();
        model.addAttribute("comm",call);
        return "Order_items";
    }
    @RequestMapping("/alls")
    public String alls(Model model, Order_items order_items){
        List<Order_items> all = service.all(order_items);
        model.addAttribute("order_items",all);
        model.addAttribute("oitem",order_items);
        List<Orde> oall = service.oall();
        model.addAttribute("orde",oall);
        List<Commodity> call = service.call();
        model.addAttribute("comm",call);
        return "AAAA";
    }
    @RequestMapping("/order")
    public String order(Model model){
        List<Orde> oall = service.oall();
        model.addAttribute("orde",oall);
        return "Order_items";
    }
    @RequestMapping("/comm")
    public String comm(Model model){
        List<Commodity> call = service.call();
        model.addAttribute("comm",call);
        return "Order_items";
    }
    @RequestMapping("/add")
    public String add(Order_items order_items){
        service.add(order_items);
        return "redirect:/Order_items/all";
    }
    @RequestMapping("/adds")
    @ResponseBody
    public String adds(List<Order_items> order_items){

        service.adds(order_items);
        return "ok";
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
        Order_items selectbyid = service.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Order_items order_items){
        service.upd(order_items);
        return "redirect:/Order_items/all";
    }
    @RequestMapping("/shenhe")
    public String shenhe(Order_items order_items){
        service.shenhe(order_items);
        if(order_items.getPoi_state()==0){
            service.upsotck(order_items);
        }else if(order_items.getPoi_state()==1){
            service.addupsotck(order_items);
        }else if(order_items.getPoi_state()==2){
            service.upsotck(order_items);
        }

        return "redirect:/Order_items/all";
    }
    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        service.batchDel(ids);
        return "ok";
    }
}
