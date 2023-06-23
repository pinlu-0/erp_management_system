package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class In_bill {
    //进货单
    private Integer pib_id;//主键
    private Integer supp_id;//供货商外键
    private Suppliers suppliers;//
    private Date pib_date;//进货日期
    private String pib_dates;//用字符串接收从数据库查出来的日期
    private Integer oper_id;//业务员外键
    private Operator operator;
    private String cbill;//制单人
    private String Inspector;//验收员
    private String keeper;//保管员
}
