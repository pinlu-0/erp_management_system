package com.aaa.dao;

import com.aaa.model.Operator;
import com.aaa.model.Suppliers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SuppliersDao {
    public int add(Suppliers suppliers);//增加
    public int del(Integer id);//删除
    //修改
    public Suppliers selectbyid(Integer id);
    public int upd(Suppliers suppliers);
    //条件查询
    public List<Suppliers> all(Suppliers suppliers);

    public List<Operator> opall();//业务员清单表下拉框

    public int batchDel(Integer[] id);//多选删除
}