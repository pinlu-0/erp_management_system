package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    //库存表
    private Integer comm_id;//商品外键、
    private Integer amount;//商品数量
    private Integer money;//商品金额
    private Integer depot_id;//仓库外键
    private Depot depot;
    private Commodity commodity;
    private Contract contract;
    private Suppliers suppliers;
}