package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_items {
    //采购订单明细表
    private Integer poi_id;//订单明细表
    private Integer po_id;//采购订单表外键
    private Integer comm_id;//商品清单表
    private Integer poi_count;//订货数量
    private Integer purc_price;//进价
    private Commodity commodity;//商品信息类
    private  Orde orde;//采购订单类
    private Suppliers suppliers;
    private Operator operator;
    private Integer poi_state;//1审核通过，0 待审核 2审核不通过
    private Depot depot;
}
