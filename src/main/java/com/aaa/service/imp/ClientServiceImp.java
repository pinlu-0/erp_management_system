package com.aaa.service.imp;

import com.aaa.dao.ClientDao;
import com.aaa.model.Client;
import com.aaa.model.Operator;
import com.aaa.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientServiceImp implements ClientService {
    @Autowired
    ClientDao clientDao;
    @Override
    public int add(Client client) {
        return clientDao.add(client);
    }

    @Override
    public int del(Integer id) {
        return clientDao.del(id);
    }

    @Override
    public Client selectbyid(Integer id) {
        return clientDao.selectbyid(id);
    }

    @Override
    public int upd(Client client) {
        return clientDao.upd(client);
    }

    @Override
    public List<Client> all(Client client) {
        return clientDao.all(client);
    }

    @Override
    public List<Operator> opall() {
        return clientDao.opall();
    }

    @Override
    public int batchDel(Integer[] id) {
        return clientDao.batchDel(id);
    }
}

