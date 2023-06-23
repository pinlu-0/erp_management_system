package com.aaa.service;

import com.aaa.model.Erp_role;
import com.aaa.model.Erp_user;
import com.aaa.model.Operator;

import java.util.List;

public interface Erp_userService {
    public int add(Erp_user erp_user);//增加
    public int del(Integer id);//删除
    //修改
    public Erp_user selectbyid(Integer id);
    public int upd(Erp_user erp_user);
    //条件查询
    public List<Erp_user> all(Erp_user erp_user);

    public List<Erp_role> rrall();//角色下拉框
    public List<Operator> opall();//员工下拉框
    public int qi(Integer id);//启用
    public int jin(Integer id);//禁用

    //登录
    public Erp_user login(String u_name, String u_pwd);


}