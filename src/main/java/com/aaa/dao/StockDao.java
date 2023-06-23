package com.aaa.dao;

import com.aaa.model.Commodity;
import com.aaa.model.Depot;
import com.aaa.model.Stock;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StockDao {
    public int add(Stock stock);//增加
    //条件查询
    public List<Stock> all(Stock stock);

    public List<Depot> deall();//仓库下拉框
    public List<Commodity> coall();//商品下拉框
}

