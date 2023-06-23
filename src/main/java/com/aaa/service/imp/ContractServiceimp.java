package com.aaa.service.imp;

import com.aaa.dao.ContractDao;
import com.aaa.model.Commodity;
import com.aaa.model.Contract;
import com.aaa.model.Suppliers;
import com.aaa.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContractServiceimp implements ContractService {
    @Autowired
    ContractDao dao;
    @Override
    public int add(Contract contract) {
        return dao.add(contract);
    }

    @Override
    public int del(Integer id) {
        return dao.del(id);
    }

    @Override
    public Contract selectbyid(Integer id) {
        return dao.selectbyid(id);
    }

    @Override
    public int upd(Contract contract) {
        return dao.upd(contract);
    }

    @Override
    public List<Contract> all(Contract contract) {
        return dao.all(contract);
    }

    @Override
    public List<Suppliers> suall() {
        return dao.suall();
    }

    @Override
    public List<Commodity> coall() {
        return dao.coall();
    }
}
