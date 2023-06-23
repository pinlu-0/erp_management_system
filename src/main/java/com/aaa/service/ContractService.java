package com.aaa.service;

import com.aaa.model.Commodity;
import com.aaa.model.Contract;
import com.aaa.model.Suppliers;

import java.util.List;

public interface ContractService {
    public int add(Contract contract);//增加
    public int del(Integer id);//删除
    //修改
    public Contract selectbyid(Integer id);
    public int upd(Contract contract);
    //条件查询
    public List<Contract> all(Contract contract);

    public List<Suppliers> suall();//供货商下拉框
    public List<Commodity> coall();//商品下拉框

}
