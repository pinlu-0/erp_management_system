package com.aaa.controller;

import com.aaa.model.Store;
import com.aaa.service.StoreService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Store")
public class StoreController {
    @Autowired
    StoreService storeService;
    @RequestMapping("/all")
    public String all(Model model, Store store){
        List<Store> all = storeService.all(store);
        model.addAttribute("stores",all);
        model.addAttribute("st",store);
        return "Stores";
    }
    @RequestMapping("/add")
    public String add(Store store){
        storeService.add(store);
        return "redirect:/Store/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        storeService.del(id);
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id){
        Store selectbyid = storeService.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Store store){
        storeService.upd(store);
        return "redirect:/Store/all";
    }

    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        storeService.batchDel(ids);
        return "ok";
    }
}

