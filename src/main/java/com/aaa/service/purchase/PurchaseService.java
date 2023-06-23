package com.aaa.service.purchase;

import com.aaa.model.Commodity;
import com.aaa.model.Depot;
import com.aaa.model.Orde;
import com.aaa.model.Suppliers;
import com.aaa.vo.PurchaseAnd;

import java.util.List;

public interface PurchaseService {
    //查询所有订单
    List<Orde> queryAllPur();

    //根据id查询订单详细信息
    Orde queryOrderById(int id);

    //模糊查询订单
    List<Orde> like_search(PurchaseAnd purchaseAnd);

    //查询供货商
    List<Suppliers> queryAllSupplier();

    //查询库存表
    List<Depot> queryAllDepot();

    //查询商品
    List<Commodity> queryAllGoods(int depot_id);

    //查询商品信息
    List<Commodity> queryAllGoodsInfo(int goods_id);

    //增加订单信息
    int add_order(PurchaseAnd purchaseAnd);

    //批量删除
    int del_bat(List<Integer> ids);

    //批量删除
    int del_by_Id(int ids);

}
