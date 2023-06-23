package com.aaa.controller;


import com.aaa.model.Commodity;
import com.aaa.model.Depot;
import com.aaa.model.Orde;
import com.aaa.model.Suppliers;
import com.aaa.service.purchase.PurchaseService;
import com.aaa.until.BaseController;
import com.aaa.until.Msg;
import com.aaa.vo.PurchaseAnd;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Controller
@RequestMapping("/purchase")
public class PurchaseController extends BaseController {
    @Autowired
    PurchaseService service;

    /**
     * 查询采购订单
     *
     * @param model
     * @return
     */
    @RequestMapping("/query_order")
    public String queryAllOrder(Model model, HttpSession session) {
        //获取操作员
        Object loginUser = session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        //查询所有订单信息
        List<Orde> orders = service.queryAllPur();
        model.addAttribute("orders", orders);
        //查询供应商
        List<Suppliers> suppliers = service.queryAllSupplier();
        model.addAttribute("suppliers", suppliers);
        return "pages/purchase/purchase_order";
    }
    @RequestMapping("/queryOrderById")
    @ResponseBody
    public Orde queryOrderById(int id){
        Orde orde = service.queryOrderById(id);
        return orde;
    }
    /**
     * 模糊查询订单
     *
     * @param model
     * @param
     * @return
     */

    @RequestMapping("/like_search")
    public String likeSearch(Model model, PurchaseAnd purchaseAnd) {
        System.out.println("=========================="+purchaseAnd);
        List<Orde> orders = service.like_search(purchaseAnd);
        System.out.println("=================Orders=============="+orders);
        model.addAttribute("orders",orders);
        return "redirect:pages/purchase/purchase_order";
    }

    /**
     * 增加采购订单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/wareHousing")
    public Msg wareHousing() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String currentTime = sdf.format(new Date());//获取当前系统时间

        //随机数  拼接订单号
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1) + 1000);//获取4位随机数
        String sd = "SD" + str + rannum;
        return Msg.success().add("currentTime", currentTime).add("sd", sd);
    }

    /**
     * 查询仓库信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/depot")
    public Msg queryAllDepot() {
        List<Depot> depots = service.queryAllDepot();
        return Msg.success().add("depots", depots);
    }

    /**
     * 查询商品
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/goods")
    public Msg queryAllGoods(int depot_id) {
        List<Commodity> allGoods = service.queryAllGoods(depot_id);
        return Msg.success().add("allGoods", allGoods);
    }

    /**
     * 根据商品id查询商品信息
     *
     * @param goods_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/goodsInfo")
    public Msg queryAllGoodsInfo(int goods_id) {
        List<Commodity> goodsInfo = service.queryAllGoodsInfo(goods_id);
        return Msg.success().add("goodsInfo", goodsInfo);
    }

    /**
     * 增加订单信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/add_order")
    public Msg add_order(String list) {
        int order = 0;
        //获取前端传来的Json字符串
        JSONArray obj = JSONArray.fromObject(list);//将json字符串转换成json数组
        for (int i = 0; i < obj.size(); i++) {
            JSONObject jsonObj = obj.getJSONObject(i);//将json数组转换成json对象
            PurchaseAnd purchaseAnd = (PurchaseAnd) JSONObject.toBean(jsonObj, PurchaseAnd.class);//再将json对象强转成自定义的业务实体类
            order = service.add_order(purchaseAnd);
        }
        return Msg.success().add("count", order);
    }

    /**
     * 采购入库
     *
     * @return
     */
    @RequestMapping("/storage")
    public String PurchaseStorage() {
        return "pages/purchase/purchase_storage";
    }

    /**
     * 采购退货
     *
     * @return
     */
    @RequestMapping("/return")
    public String PurchaseReturn() {
        return "pages/purchase/purchase_return";
    }

    /**
     * 批量删除
     *
     * @return
     */
    @PostMapping("/del_bat")
    @ResponseBody
    public int del_batches(String ids) {
        int i =0;
        if (ids.contains("-")) {//ids中如果包含 - 就说明是批量删除
            List<Integer> ids_list = new ArrayList<>();
            String[] str_ids = ids.split("-");
            for (String str : str_ids) {
                int ids_int = Integer.parseInt(str);
                ids_list.add(ids_int);
            }
            //调用删除
            i = service.del_bat(ids_list);
        } else {//不包含  就说明是单个删除
            int id = Integer.parseInt(ids);
            //调用删除
            i = service.del_by_Id(id);
        }
        return i;
    }
}
