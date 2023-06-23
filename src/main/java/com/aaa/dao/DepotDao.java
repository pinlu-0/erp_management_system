package com.aaa.dao;

import com.aaa.model.Depot;
import com.aaa.model.Operator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepotDao {
    //仓库
    public int add(Depot depot);//增加
    public int del(Integer id);//删除

    public List<Depot> all(Depot depot);//条件查询
    //修改
    public Depot selectbyid(Integer id);
    public int upd(Depot depot);

    public int batchDel(Integer[] id);//多选删除
    public List<Operator> opall();
}