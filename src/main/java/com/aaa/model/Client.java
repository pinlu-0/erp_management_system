package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    //客户清单表
    private Integer clie_id;//客户编号
    private String clie_spell_code;//拼音编码
    private String clie_short_name;//简称
    private String clie_name;//名称
    private String clie_link_man;//联系人
    private String clie_address;//地址
    private String clie_post_code;//邮编
    private String clie_tel;//电话
    private String clie_fax;//传真
    private String clie_bank;//开户行
    private String clie_iban;//银行账户
    private Integer oper_id;//业务员外键
    private String clie_creditlimt;//授信额度
    private Operator operator;
}
