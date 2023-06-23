package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Depot {
    //仓库表
    private Integer depot_id;//仓库编号
    private String depot_name;//仓库名
    private String depot_sort;//仓库编号
    private String depot_desc;//备注
    private String depot_address;//仓库地址
    private Integer oper_id;//业务员外键
    private String depot_remark;//备注
    private Operator operator;
}
