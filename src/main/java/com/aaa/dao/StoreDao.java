package com.aaa.dao;

import com.aaa.model.Store;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StoreDao {
    //门店
    public int add(Store store);//增加

    public List<Store> all(Store store);//条件查询
    //修改
    public int del(Integer id);//删除
    public Store selectbyid(Integer id);
    public int upd(Store store);

    public int batchDel(Integer[] id);//多选删除
}
