package com.aaa.dao;

import com.aaa.model.Commodity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommodityDao {
    //商品清单
    public int add(Commodity commodity);//添加
    public int delete(Integer comm_id);//删除

    public List<Commodity> all(Commodity commodity);//查询全部和条件查询
    //修改
    public Commodity selectbyid(Integer id);
    public int upd(Commodity commodity);
    public int batchDel(Integer[] id);//多选删除
}
