package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    //门店
    private Integer stor_id;//门店编号
    private String stor_name;//门店名
    private String stor_address;//门店地址
    private String stor_desc;//备注
}