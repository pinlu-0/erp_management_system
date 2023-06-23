package com.aaa.dao;

import com.aaa.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PurchaseMapper {
    //查询所有订单
    List<Orde> queryAllPur();

    //根据id查询订单详细信息
    Orde queryOrderById(int id);

    //模糊查询订单
    List<Orde> like_search(Orde orde);

    //查询供货商
    List<Suppliers> queryAllSupplier();

    //查询库存表
    List<Depot> queryAllDepot();

    //查询商品
    List<Commodity> queryAllGoods(int depot_id);

    //查询商品
    List<Commodity> queryAllGoodsInfo(int goods_id);

    //增加订单
    int add_order(Orde purchase);

    //增加订单详细
    int add_order_item(Order_items purchase_order_items);

    //批量删除
    int del_bat(List<Integer> ids);

    //批量删除
    int del_by_Id(int ids);
}
