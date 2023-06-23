package com.aaa.service.imp;

import com.aaa.dao.OperatorDao;
import com.aaa.model.Operator;
import com.aaa.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperatorServiceimp implements OperatorService {
    @Autowired
    OperatorDao operatorDao;

    @Override
    public int add(Operator operator) {
        return operatorDao.add(operator);
    }

    @Override
    public int del(Integer id) {
        return operatorDao.del(id);
    }

    @Override
    public List<Operator> all(Operator operator) {
        return operatorDao.all(operator);
    }

    @Override
    public Operator selectbyid(Integer id) {
        return operatorDao.selectbyid(id);
    }

    @Override
    public int upd(Operator operator) {
        return operatorDao.upd(operator);
    }

    @Override
    public int batchDel(Integer[] id) {
        return operatorDao.batchDel(id);
    }
}

