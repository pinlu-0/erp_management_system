package com.aaa.service.imp;

import com.aaa.dao.In_itemsDao;
import com.aaa.model.Commodity;
import com.aaa.model.Depot;
import com.aaa.model.In_bill;
import com.aaa.model.In_items;
import com.aaa.service.In_itemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class In_itemsServiceimp implements In_itemsService {

    @Autowired
    In_itemsDao in_itemsDao;
    @Override
    public int add(In_items in_items) {
        return in_itemsDao.add(in_items);
    }

    @Override
    public int del(Integer id) {
        return in_itemsDao.del(id);
    }

    @Override
    public In_items selectbyid(Integer id) {
        return in_itemsDao.selectbyid(id);
    }

    @Override
    public int upd(In_items in_items) {
        return in_itemsDao.upd(in_items);
    }

    @Override
    public List<In_items> all(In_items in_items) {
        return in_itemsDao.all(in_items);
    }

    @Override
    public List<In_bill> iball() {
        return in_itemsDao.iball();
    }

    @Override
    public List<Commodity> coall() {
        return in_itemsDao.coall();
    }

    @Override
    public int batchDel(Integer[] id) {
        return in_itemsDao.batchDel(id);
    }

    @Override
    public int shenhe(In_items in_items) {
        return in_itemsDao.shenhe(in_items);
    }

    @Override
    public int addupsotck(In_items in_items) {
        return in_itemsDao.addupsotck(in_items);
    }

    @Override
    public int upsotck(In_items in_items) {
        return in_itemsDao.upsotck(in_items);
    }

    @Override
    public List<Depot> depot() {
        return in_itemsDao.depot();
    }
}