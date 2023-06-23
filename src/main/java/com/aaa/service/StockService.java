package com.aaa.service;

import com.aaa.model.Commodity;
import com.aaa.model.Depot;
import com.aaa.model.Stock;

import java.util.List;

public interface StockService {
    public int add(Stock stock);//增加
    //条件查询
    public List<Stock> all(Stock stock);

    public List<Depot> deall();//仓库下拉框
    public List<Commodity> coall();//商品下拉框

}
