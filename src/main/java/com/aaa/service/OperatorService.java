package com.aaa.service;

import com.aaa.model.Operator;

import java.util.List;

public interface OperatorService {
    //业务员清单
    public int add(Operator operator);//增加

    public int del(Integer id);//删除

    public List<Operator> all(Operator operator);//条件查询

    //修改
    public Operator selectbyid(Integer id);

    public int upd(Operator operator);

    public int batchDel(Integer[] id);//多选删除
}