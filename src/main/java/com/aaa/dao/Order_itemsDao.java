package com.aaa.dao;

import com.aaa.model.Commodity;
import com.aaa.model.Orde;
import com.aaa.model.Order_items;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Order_itemsDao {
    public int add(Order_items order_items);//增加
    public int del(Integer id);//删除
    //修改
    public Order_items selectbyid(Integer id);
    public int upd(Order_items order_items);
    //审核
    public int shenhe(Order_items order_items);
    //条件查询
    public List<Order_items> all(Order_items order_items);

    public List<Commodity> call();//商品下拉框
    public List<Orde> oall();//采购订单下拉框

    public int batchDel(Integer[] id);//多选删除
    //采购审核通过添加商品数量
    public int addupsotck(Order_items order_items);
    //采购审核通过之后出现问题修改成不通过是商品数量减少
    public int upsotck(Order_items order_items);
    //批量添加
    public int adds(List<Order_items> order_items);
}