package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orde {
    //采购订单表
    private Integer po_id;//订单编号
    private Integer supp_id;//供货商编号

    private java.util.Date po_date;//订货日期
    private String po_dates;//用字符串接收从数据库查出来的日期
    private String str_po_date;
    private java.util.Date po_begain_date;//有效日期
    private String po_begain_dates;//用字符串接收从数据库查出来的日期
    private Integer depot_id;//仓库id
    private Date pe_end_date;//有效止日
    private String pe_end_dates;//用字符串接收从数据库查出来的日期
    private String remark;
    private Integer oper_id;//业务员编号外键
    private String cbill;//制单人
    private String order_num;//订单编号
    private Suppliers suppliers;//供货商引用类
    private Operator operator;//操作员引用类
    private Order_items order_items;//订单详细表引用类
    private Commodity commodity;//商品引用类
    private Depot depot;
    private Stock stock;
}
