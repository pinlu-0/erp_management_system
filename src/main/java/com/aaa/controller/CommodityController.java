package com.aaa.controller;

import com.aaa.model.Commodity;
import com.aaa.service.CommodityService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.util.List;

@RequestMapping("/Commodity")
@Controller
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @RequestMapping("/all")
    public String all(Commodity commodity, Model model){
        List<Commodity> all = commodityService.all(commodity);
        model.addAttribute("comm",all);
        model.addAttribute("cd",commodity);
        return "Commodity";
    }
    @RequestMapping("/add")
    public String add(Commodity commodity){
        commodityService.add(commodity);
        return "redirect:/Commodity/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(Integer id){
        commodityService.delete(id);
      
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id){
        Commodity selectbyid = commodityService.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Commodity commodity){
        commodityService.upd(commodity);
        return "redirect:/Commodity/all";
    }

    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        commodityService.batchDel(ids);
        return "ok";
    }

}
