package com.aaa.service;

import com.aaa.model.Client;
import com.aaa.model.Operator;
import com.aaa.model.Sale_order;

import java.util.List;

public interface Sale_orderService {
    public int add(Sale_order sale_order);//增加
    public int del(Integer id);//删除
    //修改
    public Sale_order selectbyid(Integer id);
    public int upd(Sale_order sale_order);
    //条件查询
    public List<Sale_order> all(Sale_order sale_order);
    public List<Operator> opall();//业务员清单表下拉框
    public List<Client> clall();//客户下拉框

    public int batchDel(Integer[] id);//多选删除
}
