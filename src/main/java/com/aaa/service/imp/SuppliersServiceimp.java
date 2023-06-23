package com.aaa.service.imp;

import com.aaa.dao.SuppliersDao;
import com.aaa.model.Operator;
import com.aaa.model.Suppliers;
import com.aaa.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuppliersServiceimp implements SuppliersService {
    @Autowired
    SuppliersDao suppliersDao;
    @Override
    public int add(Suppliers suppliers) {
        return suppliersDao.add(suppliers);
    }

    @Override
    public int del(Integer id) {
        return suppliersDao.del(id);
    }

    @Override
    public Suppliers selectbyid(Integer id) {
        return suppliersDao.selectbyid(id);
    }

    @Override
    public int upd(Suppliers suppliers) {
        return suppliersDao.upd(suppliers);
    }

    @Override
    public List<Suppliers> all(Suppliers suppliers) {
        return suppliersDao.all(suppliers);
    }

    @Override
    public List<Operator> opall() {
        return suppliersDao.opall();
    }

    @Override
    public int batchDel(Integer[] id) {
        return suppliersDao.batchDel(id);
    }
}