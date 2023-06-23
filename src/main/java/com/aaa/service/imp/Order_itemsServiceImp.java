package com.aaa.service.imp;

import com.aaa.dao.Order_itemsDao;
import com.aaa.model.Commodity;
import com.aaa.model.Orde;
import com.aaa.model.Order_items;
import com.aaa.service.Order_itemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Order_itemsServiceImp implements Order_itemsService {

    @Autowired
    Order_itemsDao order_itemsDao;

    @Override
    public int add(Order_items order_items) {
        return order_itemsDao.add(order_items);
    }

    @Override
    public int del(Integer id) {
        return order_itemsDao.del(id);
    }

    @Override
    public Order_items selectbyid(Integer id) {
        return order_itemsDao.selectbyid(id);
    }

    @Override
    public int upd(Order_items order_items) {
        return order_itemsDao.upd(order_items);
    }

    @Override
    public int shenhe(Order_items order_items) {
        return order_itemsDao.shenhe(order_items);
    }

    @Override
    public List<Order_items> all(Order_items order_items) {
        return order_itemsDao.all(order_items);
    }

    @Override
    public List<Commodity> call() {
        return order_itemsDao.call();
    }

    @Override
    public List<Orde> oall() {
        return order_itemsDao.oall();
    }

    @Override
    public int batchDel(Integer[] id) {
        return order_itemsDao.batchDel(id);
    }

    @Override
    public int addupsotck(Order_items order_items) {
        return order_itemsDao.addupsotck(order_items);
    }

    @Override
    public int upsotck(Order_items order_items) {
        return order_itemsDao.upsotck(order_items);
    }

    @Override
    public int adds(List<Order_items> order_items) {
        return order_itemsDao.adds(order_items);
    }
}

