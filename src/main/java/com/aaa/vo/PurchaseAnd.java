package com.aaa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseAnd {
    private Integer warehouse_name;//仓库id
    private Integer trade_name;
    private String repertory;
    private Integer count;//数量
    private Integer price;//单价
    private Integer sum;//总金额
    private String remark;//备注
    private Integer suppliers;//供货商
    private Date bill_Date;//制单日期
    private String cbill;//制单人
    private Integer oper_id;//业务员外键
    private String order_num;//订单号
    private String comm_name;//商品名
}
