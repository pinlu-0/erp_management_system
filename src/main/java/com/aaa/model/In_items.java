package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class In_items {
    //进货单明细实体类
    private Integer pii_id;//主键
    private Integer comm_id;//商品清单外键
    private Commodity commodity;//
    private Integer pib_id;//进货单外键
    private In_bill in_bill;
    private Integer pii_amount;//进货数量
    private Integer purc_price;//进价
    private Integer pii_state;//1审核通过，0 待审核 2审核不通过
    private Integer depot_id;//仓库id
    private Depot depot;
}