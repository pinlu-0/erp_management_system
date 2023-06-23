package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {
    //商品清单表
    private Integer comm_id;//商品清单表主键
    private String comm_bar_code;//条形码
    private String comm_name;//商品名
    private String comm_spell_code;//拼音编码
    private String comm_standard;//商品规格
    private String comm_unit;//单位
    private String comm_producing_area;//产地
    private String comm_sort;//类别
    private Integer purchase_price;//进货价
    private Integer sale_price1;//销售价1
    private Integer sale_price2;//销售价2
    private Integer lowest_sale_price;//最低销售价
}
