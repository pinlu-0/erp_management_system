package com.aaa.service.imp;

import com.aaa.dao.Sale_orderDao;
import com.aaa.model.Client;
import com.aaa.model.Operator;
import com.aaa.model.Sale_order;
import com.aaa.service.Sale_orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Sale_orderServiceImp implements Sale_orderService {
    @Autowired
    Sale_orderDao sale_orderDao;
    @Override
    public int add(Sale_order sale_order) {
        return sale_orderDao.add(sale_order);
    }

    @Override
    public int del(Integer id) {
        return sale_orderDao.del(id);
    }

    @Override
    public Sale_order selectbyid(Integer id) {
        return sale_orderDao.selectbyid(id);
    }

    @Override
    public int upd(Sale_order sale_order) {
        return sale_orderDao.upd(sale_order);
    }

    @Override
    public List<Sale_order> all(Sale_order sale_order) {
        return sale_orderDao.all(sale_order);
    }

    @Override
    public List<Operator> opall() {
        return sale_orderDao.opall();
    }

    @Override
    public List<Client> clall() {
        return sale_orderDao.clall();
    }

    @Override
    public int batchDel(Integer[] id) {
        return sale_orderDao.batchDel(id);
    }
}
