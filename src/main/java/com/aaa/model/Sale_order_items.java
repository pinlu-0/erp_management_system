package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale_order_items {
    //销售订单明细表
    private Integer soi_id;//销售订单编号
    private Integer so_id;//销售订单表外键
    private Sale_order sale_order;
    private Integer comm_id;//货物编号
    private Commodity commodity;//商品表外键
    private Integer so_amount;//销售数量
    private Integer sale_price;//销售价
    private Integer soi_state;//1审核通过，0 待审核 2审核不通过
    private Integer depot_id;//仓库id
    private Depot depot;
}
