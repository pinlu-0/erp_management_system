package com.aaa.service;

import com.aaa.model.Commodity;

import java.util.List;

public interface CommodityService {
    public int add(Commodity commodity);//添加
    public int delete(Integer comm_id);//删除

    public List<Commodity> all(Commodity commodity);//查询全部和条件查询
    //修改
    public Commodity selectbyid(Integer id);
    public int upd(Commodity commodity);
    public int batchDel(Integer[] id);//多选删除
}