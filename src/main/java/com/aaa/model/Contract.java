package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    //采购合同表
    private Integer pc_id;//合同编号
    private Integer supp_id;//供货商外键，供货商编号
    private Integer comm_id;//商品清单表，货物编号
    private Integer pc_price;//进价
    private String pc_pay;//付款方式
    private Date pc_date;//签订日期
    private String pc_dates;//用字符串接收从数据库查出来的日期
    private String pc_period;//合同期限
    private Commodity commodity;//商品清单表
    private Suppliers suppliers;//供货商外键
}
