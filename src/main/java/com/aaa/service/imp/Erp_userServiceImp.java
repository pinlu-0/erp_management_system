package com.aaa.service.imp;

import com.aaa.dao.Erp_userDao;
import com.aaa.model.Erp_role;
import com.aaa.model.Erp_user;
import com.aaa.model.Operator;
import com.aaa.service.Erp_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Erp_userServiceImp implements Erp_userService {
    @Autowired
    Erp_userDao erp_userDao;

    @Override
    public int add(Erp_user erp_user) {
        return erp_userDao.add(erp_user);
    }

    @Override
    public int del(Integer id) {
        return erp_userDao.del(id);
    }

    @Override
    public Erp_user selectbyid(Integer id) {
        return erp_userDao.selectbyid(id);
    }

    @Override
    public int upd(Erp_user erp_user) {
        return erp_userDao.upd(erp_user);
    }

    @Override
    public List<Erp_user> all(Erp_user erp_user) {
        return erp_userDao.all(erp_user);
    }

    @Override
    public List<Erp_role> rrall() {
        return erp_userDao.rrall();
    }

    @Override
    public List<Operator> opall() {
        return erp_userDao.opall();
    }

    @Override
    public int qi(Integer id) {
        return erp_userDao.qi(id);
    }

    @Override
    public int jin(Integer id) {
        return erp_userDao.jin(id);
    }

    @Override
    public Erp_user login(String u_name, String u_pwd) {
        return erp_userDao.login(u_name,u_pwd);
    }
}

