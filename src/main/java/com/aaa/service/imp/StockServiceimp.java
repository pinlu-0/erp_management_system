package com.aaa.service.imp;

import com.aaa.dao.StockDao;
import com.aaa.model.Commodity;
import com.aaa.model.Depot;
import com.aaa.model.Stock;
import com.aaa.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockServiceimp implements StockService {
    @Autowired
    StockDao stockDao;
    @Override
    public int add(Stock stock) {
        return stockDao.add(stock);
    }

    @Override
    public List<Stock> all(Stock stock) {
        return stockDao.all(stock);
    }


    @Override
    public List<Depot> deall() {
        return stockDao.deall();
    }

    @Override
    public List<Commodity> coall() {
        return stockDao.coall();
    }
}