package com.aaa.controller;

import com.aaa.model.Commodity;
import com.aaa.model.Depot;
import com.aaa.model.Stock;
import com.aaa.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Stock")
public class StockController {
    @Autowired
    StockService stockService;
    @RequestMapping("/all")
    public String all(Model model, Stock stock){
        List<Stock> all = stockService.all(stock);
        model.addAttribute("stock",stock);
        model.addAttribute("stocks",all);
        List<Depot> deall = stockService.deall();
        model.addAttribute("depot",deall);
        List<Commodity> commodities=stockService.coall();
        model.addAttribute("com",commodities);
        return "Stocks";
    }
    @RequestMapping("/add")
    public String add(Stock stock){
        stockService.add(stock);
        return "redirect:/Stock/all";
    }

}
