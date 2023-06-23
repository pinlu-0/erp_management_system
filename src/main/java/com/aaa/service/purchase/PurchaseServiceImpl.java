package com.aaa.service.purchase;

import com.aaa.dao.PurchaseMapper;
import com.aaa.model.*;
import com.aaa.vo.PurchaseAnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{
    @Autowired
    PurchaseMapper mapper;

    /**
     * 查询所有订单
     *
     * @return
     */
    @Override
    public List<Orde> queryAllPur() {
        return mapper.queryAllPur();
    }

    /**
     * 根据id查询订单的详细信息
     *
     * @param id
     * @return
     */
    @Override
    public Orde queryOrderById(int id) {
        return mapper.queryOrderById(id);
    }

    /**
     * 模糊查询订单
     *
     * @param purchaseAnd
     * @return
     */
    @Override
    public List<Orde> like_search(PurchaseAnd purchaseAnd) {
        Orde purchase = new Orde();
        purchase.setOrder_num(purchaseAnd.getOrder_num());//给订单编号字段赋值
        purchase.setPo_date(purchaseAnd.getBill_Date());//给单据日期赋值
        Commodity commodity = new Commodity();
        commodity.setComm_name(purchaseAnd.getComm_name());//给商品名赋值
        purchase.setCommodity(commodity);
        System.out.println("===========Service" + purchaseAnd.getOrder_num());
        return mapper.like_search(purchase);
    }

    /**
     * 查询供货商
     *
     * @return
     */
    @Override
    public List<Suppliers> queryAllSupplier() {
        return mapper.queryAllSupplier();
    }

    /**
     * 查询仓库表
     *
     * @return
     */
    @Override
    public List<Depot> queryAllDepot() {
        return mapper.queryAllDepot();
    }

    /**
     * 查询商品
     *
     * @return
     */
    @Override
    public List<Commodity> queryAllGoods(int depot_id) {
        return mapper.queryAllGoods(depot_id);
    }

    /**
     * 查询商品
     *
     * @param goods_id
     * @return
     */
    @Override
    public List<Commodity> queryAllGoodsInfo(int goods_id) {
        return mapper.queryAllGoodsInfo(goods_id);
    }

    /**
     * 增加订单信息
     *
     * @param
     * @return
     */
    @Override
    public int add_order(PurchaseAnd purchaseAnd) {
        int i = 0;
        //添加订单表
        Orde purchase = new Orde();
        purchase.setSupp_id(purchaseAnd.getSuppliers());//供应商
        purchase.setPo_date(purchaseAnd.getBill_Date());//制单日期
        purchase.setOper_id(purchaseAnd.getOper_id());//制单人id
        purchase.setOrder_num(purchaseAnd.getOrder_num());//订单号
        purchase.setDepot_id(purchaseAnd.getWarehouse_name());
        purchase.setRemark(purchaseAnd.getRemark());
        i = mapper.add_order(purchase);
        if (i > 0) {
            //添加订单详细表
            Order_items purchase_order_items = new Order_items();
            purchase.setSupp_id(purchaseAnd.getSuppliers());//供货商id
            purchase_order_items.setComm_id(purchaseAnd.getTrade_name());//商品id
            purchase_order_items.setPo_id(purchase.getPo_id());
            purchase_order_items.setPoi_count(purchaseAnd.getCount());
            purchase_order_items.setPurc_price(purchaseAnd.getPrice());
            mapper.add_order_item(purchase_order_items);
        }
        return i;
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public int del_bat(List<Integer> ids) {
        return mapper.del_bat(ids);
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @Override
    public int del_by_Id(int ids) {
        return mapper.del_by_Id(ids);
    }
}
