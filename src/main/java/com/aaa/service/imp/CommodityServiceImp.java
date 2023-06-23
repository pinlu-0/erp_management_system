package com.aaa.service.imp;

import com.aaa.dao.CommodityDao;
import com.aaa.model.Commodity;
import com.aaa.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommodityServiceImp implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;
    @Override
    public int add(Commodity commodity) {
        return commodityDao.add(commodity);
    }

    @Override
    public int delete(Integer comm_id) {
        return commodityDao.delete(comm_id);
    }

    @Override
    public List<Commodity> all(Commodity commodity) {
        return commodityDao.all(commodity);
    }

    @Override
    public Commodity selectbyid(Integer id) {
        return commodityDao.selectbyid(id);
    }

    @Override
    public int upd(Commodity commodity) {
        return commodityDao.upd(commodity);
    }

    @Override
    public int batchDel(Integer[] id) {
        return commodityDao.batchDel(id);
    }
}
