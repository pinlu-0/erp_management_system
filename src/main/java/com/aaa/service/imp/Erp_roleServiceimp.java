package com.aaa.service.imp;

import com.aaa.dao.Erp_roleDao;
import com.aaa.model.Erp_role;
import com.aaa.service.Erp_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Erp_roleServiceimp implements Erp_roleService {
    @Autowired
    Erp_roleDao erp_roleDao;
    @Override
    public int add(Erp_role erp_role) {
        return erp_roleDao.add(erp_role);
    }

    @Override
    public int del(Integer id) {
        return erp_roleDao.del(id);
    }

    @Override
    public Erp_role selectbyid(Integer id) {
        return erp_roleDao.selectbyid(id);
    }

    @Override
    public int upd(Erp_role erp_role) {
        return erp_roleDao.upd(erp_role);
    }

    @Override
    public List<Erp_role> all(Erp_role erp_role) {
        return erp_roleDao.all(erp_role);
    }
}
