package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Erp_role {
    //角色管理
    private Integer r_id;//角色表主键
    private String r_name;//角色名称
    private String r_code;//角色编码
    private String r_desc;//角色描述
    private Timestamp r_date;//更新时间
    private String r_dates;
}
