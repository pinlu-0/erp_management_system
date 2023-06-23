package com.aaa.dao;

import com.aaa.model.Operator;
import com.aaa.model.Orde;
import com.aaa.model.Suppliers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrdeDao {
    public int add(Orde orde);//增加
    public int del(Integer id);//删除
    //修改
    public Orde selectbyid(Integer id);
    public int upd(Orde orde);
    //条件查询
    public List<Orde> all(Orde orde);
    public List<Orde> alls(Integer po_id);
    public List<Operator> opall();//业务员清单表下拉框
    public List<Suppliers> suall();//供货商下拉框

    public int batchDel(Integer[] id);//多选删除
}

