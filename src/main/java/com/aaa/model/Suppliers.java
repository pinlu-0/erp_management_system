package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suppliers {
    //供货商
    private Integer supp_id;//供货商编码
    private String supp_spell_code;//拼音编码
    private String supp_short_name;//简称
    private String supp_name;//名称
    private String supp_address;//地址
    private String supp_post_code;//邮编
    private String supp_sort;//类型
    private String supp_tel;//电话
    private String supp_fax;//传真
    private String supp_bank;//开户行
    private String supp_iban;//银行账户
    private String supp_storage_address;//库房地址
    private String supp_storage_tel;//库房电话
    private Integer oper_id;//业务员外键
    private Operator operator;
}
