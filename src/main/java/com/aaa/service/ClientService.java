package com.aaa.service;


import com.aaa.model.Client;
import com.aaa.model.Operator;

import java.util.List;

public interface ClientService {
    public int add(Client client);//增加
    public int del(Integer id);//删除
    //修改
    public Client selectbyid(Integer id);
    public int upd(Client client);
    //条件查询
    public List<Client> all(Client client);

    public List<Operator> opall();//业务员清单表下拉框

    public int batchDel(Integer[] id);//多选删除
}
