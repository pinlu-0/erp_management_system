package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operator {
    //业务员清单表
    private Integer oper_id;//业务员编号
    private String oper_spell_code;//拼音编码
    private String oper_name;//姓名
    private String oper_sex;//性别
    private String oper_tel;//电话
    private String oper_mobile_tel;//手机
    private String oper_address;//地址
    private String oper_post_code;//邮编
    private String oper_Id_number;//身份证号
    private String oper_sort;//类别
}
