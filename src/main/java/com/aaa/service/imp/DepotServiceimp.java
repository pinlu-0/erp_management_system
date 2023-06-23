package com.aaa.service.imp;

import com.aaa.dao.DepotDao;
import com.aaa.model.Depot;
import com.aaa.model.Operator;
import com.aaa.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepotServiceimp implements DepotService {
    @Autowired
    DepotDao depotDao;
    @Override
    public int add(Depot depot) {
        return depotDao.add(depot);
    }

    @Override
    public int del(Integer id) {
        return depotDao.del(id);
    }

    @Override
    public List<Depot> all(Depot depot) {
        return depotDao.all(depot);
    }

    @Override
    public Depot selectbyid(Integer id) {
        return depotDao.selectbyid(id);
    }

    @Override
    public int upd(Depot depot) {
        return depotDao.upd(depot);
    }

    @Override
    public int batchDel(Integer[] id) {
        return depotDao.batchDel(id);
    }

    @Override
    public List<Operator> opall() {
        return depotDao.opall();
    }
}