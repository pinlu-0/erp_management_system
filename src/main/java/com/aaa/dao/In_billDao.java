package com.aaa.dao;

import com.aaa.model.In_bill;
import com.aaa.model.Operator;
import com.aaa.model.Suppliers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface In_billDao {
    public int add(In_bill in_bill);//增加
    public int del(Integer id);//删除
    //修改
    public In_bill selectbyid(Integer id);
    public int upd(In_bill in_bille);
    //条件查询
    public List<In_bill> all(In_bill in_bill);
    public List<In_bill> alls(Integer pib_id);
    public List<Operator> opall();//业务员清单表下拉框
    public List<Suppliers> suall();//供货商下拉框

    public int batchDel(Integer[] id);//多选删除
}