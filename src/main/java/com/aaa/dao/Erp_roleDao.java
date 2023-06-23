package com.aaa.dao;

import com.aaa.model.Erp_role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Erp_roleDao {
    public int add(Erp_role erp_role);//增加
    public int del(Integer id);//删除
    //修改
    public Erp_role selectbyid(Integer id);
    public int upd(Erp_role erp_role);
    //条件查询
    public List<Erp_role> all(Erp_role erp_role);

}