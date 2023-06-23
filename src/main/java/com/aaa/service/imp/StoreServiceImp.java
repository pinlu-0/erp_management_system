package com.aaa.service.imp;

import com.aaa.dao.StoreDao;
import com.aaa.model.Store;
import com.aaa.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreServiceImp implements StoreService {
    @Autowired
    StoreDao storeDao;
    @Override
    public int add(Store store) {
        return storeDao.add(store);
    }

    @Override
    public int del(Integer id) {
        return storeDao.del(id);
    }

    @Override
    public List<Store> all(Store store) {
        return storeDao.all(store);
    }

    @Override
    public Store selectbyid(Integer id) {
        return storeDao.selectbyid(id);
    }

    @Override
    public int upd(Store store) {
        return storeDao.upd(store);
    }

    @Override
    public int batchDel(Integer[] id) {
        return storeDao.batchDel(id);
    }
}