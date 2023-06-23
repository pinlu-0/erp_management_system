package com.aaa.dao;

import com.aaa.model.Commodity;
import com.aaa.model.Depot;
import com.aaa.model.In_bill;
import com.aaa.model.In_items;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface In_itemsDao {
    public int add(In_items in_items);//增加
    public int del(Integer id);//删除
    //修改
    public In_items selectbyid(Integer id);
    public int upd(In_items in_items);

    //审核
    public int shenhe(In_items in_items);
    //条件查询
    public List<In_items> all(In_items in_items);

    public List<In_bill> iball();//进货单表下拉框
    public List<Commodity> coall();//供货商下拉框

    public int batchDel(Integer[] id);//多选删除
    //采购审核通过添加商品数量
    public int addupsotck(In_items in_items);
    //采购审核通过之后出现问题修改成不通过是商品数量减少
    public int upsotck(In_items in_items);

    //仓库下拉框
    public List<Depot> depot();
}
