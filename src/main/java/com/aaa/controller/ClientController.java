package com.aaa.controller;

import com.aaa.model.Client;
import com.aaa.model.Operator;
import com.aaa.service.ClientService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @RequestMapping("/all")
    public String all(Model model, Client client){
        List<Client> all = clientService.all(client);
        model.addAttribute("clients",all);
        model.addAttribute("cl",client);
        List<Operator> opall = clientService.opall();
        model.addAttribute("op",opall);
        return "Clients";
    }
    @RequestMapping("/add")
    public String add(Client client){
        clientService.add(client);
        return "redirect:/Client/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        clientService.del(id);
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id){
        Client selectbyid = clientService.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Client client){
        clientService.upd(client);
        return "redirect:/Client/all";
    }

    @RequestMapping("/batchDel")
    @ResponseBody
    public String batchDel(@RequestParam("ids[]") Integer[] ids){
        clientService.batchDel(ids);
        return "ok";
    }
}
