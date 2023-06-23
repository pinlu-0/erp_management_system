package com.aaa.service;

import com.aaa.model.Store;

import java.util.List;

public interface StoreService {
    //门店
    public int add(Store store);//增加
    public int del(Integer id);//删除

    public List<Store> all(Store store);//条件查询
    //修改
    public Store selectbyid(Integer id);
    public int upd(Store store);

    public int batchDel(Integer[] id);//多选删除
}
