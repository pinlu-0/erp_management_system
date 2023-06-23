package com.aaa.service.imp;

import com.aaa.dao.Sale_order_itemsDao;
import com.aaa.model.*;
import com.aaa.service.Sale_order_itemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Sale_order_itemsServiceimp implements Sale_order_itemsService {
    @Autowired
    Sale_order_itemsDao sale_order_itemsDao;
    @Override
    public int add(Sale_order_items sale_order_items) {
        return sale_order_itemsDao.add(sale_order_items);
    }

    @Override
    public int del(Integer id) {
        return sale_order_itemsDao.del(id);
    }

    @Override
    public Sale_order_items selectbyid(Integer id) {
        return sale_order_itemsDao.selectbyid(id);
    }

    @Override
    public int upd(Sale_order_items sale_order_items) {
        return sale_order_itemsDao.upd(sale_order_items);
    }

    @Override
    public int shenhe(Sale_order_items sale_order_items) {
        return sale_order_itemsDao.shenhe(sale_order_items);
    }

    @Override
    public List<Sale_order_items> all(Sale_order_items sale_order_items) {
        return sale_order_itemsDao.all(sale_order_items);
    }

    @Override
    public List<Commodity> call() {
        return sale_order_itemsDao.call();
    }

    @Override
    public List<Sale_order> soall() {
        return sale_order_itemsDao.soall();
    }

    @Override
    public int batchDel(Integer[] id) {
        return sale_order_itemsDao.batchDel(id);
    }

    @Override
    public int addupsotck(Sale_order_items sale_order_items) {
        return sale_order_itemsDao.addupsotck(sale_order_items);
    }

    @Override
    public int upsotck(Sale_order_items sale_order_items) {
        return sale_order_itemsDao.upsotck(sale_order_items);
    }

    @Override
    public List<Depot> depoall() {
        return sale_order_itemsDao.depoall();
    }
}
