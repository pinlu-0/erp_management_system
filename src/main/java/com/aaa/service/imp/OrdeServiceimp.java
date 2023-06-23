package com.aaa.service.imp;

import com.aaa.dao.OrdeDao;
import com.aaa.model.Operator;
import com.aaa.model.Orde;
import com.aaa.model.Suppliers;
import com.aaa.service.OrdeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdeServiceimp implements OrdeService {
    @Autowired
    OrdeDao ordeDao;
    @Override
    public int add(Orde orde) {
        return ordeDao.add(orde);
    }

    @Override
    public int del(Integer id) {
        return ordeDao.del(id);
    }

    @Override
    public Orde selectbyid(Integer id) {
        return ordeDao.selectbyid(id);
    }

    @Override
    public int upd(Orde orde) {
        return ordeDao.upd(orde);
    }

    @Override
    public List<Orde> all(Orde orde) {
        return ordeDao.all(orde);
    }

    @Override
    public List<Operator> opall() {
        return ordeDao.opall();
    }

    @Override
    public List<Suppliers> suall() {
        return ordeDao.suall();
    }

    @Override
    public int batchDel(Integer[] id) {
        return ordeDao.batchDel(id);
    }
}

