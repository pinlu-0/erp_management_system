package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale_order {
    //销售订单实体类
    private Integer so_id;//销售订单编号
    private Integer clie_id; //客户表外键
    private Client client;

    private Date so_date;//销售日期
    private String so_dates;//用字符串接收从数据库查出来的日期

    private Date so_begain_date;//有效起日
    private String so_begain_dates;

    private Date so_end_date;//有效止日
    private String so_end_dates;

    private Integer oper_id;//业务员外键
    private Operator operator;

    private String cbill;//制单人
}
