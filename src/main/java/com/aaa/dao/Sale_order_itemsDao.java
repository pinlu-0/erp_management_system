package com.aaa.dao;

import com.aaa.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Sale_order_itemsDao {
    public int add(Sale_order_items sale_order_items);//增加
    public int del(Integer id);//删除
    //修改
    public Sale_order_items selectbyid(Integer id);
    public int upd(Sale_order_items sale_order_items);
    //审核
    public int shenhe(Sale_order_items sale_order_items);
    //条件查询
    public List<Sale_order_items> all(Sale_order_items sale_order_items);

    public List<Commodity> call();//商品下拉框
    public List<Sale_order> soall();//销售订单下拉框

    public int batchDel(Integer[] id);//多选删除
    //采购审核通过添加商品数量
    public int addupsotck(Sale_order_items sale_order_items);
    //采购审核通过之后出现问题修改成不通过是商品数量减少
    public int upsotck(Sale_order_items sale_order_items);
    /*仓库下拉框*/
    public List<Depot> depoall();
}