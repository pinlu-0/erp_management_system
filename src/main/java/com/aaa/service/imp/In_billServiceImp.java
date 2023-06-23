package com.aaa.service.imp;

import com.aaa.dao.In_billDao;
import com.aaa.model.In_bill;
import com.aaa.model.Operator;
import com.aaa.model.Suppliers;
import com.aaa.service.In_billService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class In_billServiceImp implements In_billService {
    @Autowired
    In_billDao in_billDao;
    @Override
    public int add(In_bill in_bill) {
        return in_billDao.add(in_bill);
    }

    @Override
    public int del(Integer id) {
        return in_billDao.del(id);
    }

    @Override
    public In_bill selectbyid(Integer id) {
        return in_billDao.selectbyid(id);
    }

    @Override
    public int upd(In_bill in_bille) {
        return in_billDao.upd(in_bille);
    }

    @Override
    public List<In_bill> all(In_bill in_bill) {
        return in_billDao.all(in_bill);
    }

    @Override
    public List<Operator> opall() {
        return in_billDao.opall();
    }

    @Override
    public List<Suppliers> suall() {
        return in_billDao.suall();
    }

    @Override
    public int batchDel(Integer[] id) {
        return in_billDao.batchDel(id);
    }
}

