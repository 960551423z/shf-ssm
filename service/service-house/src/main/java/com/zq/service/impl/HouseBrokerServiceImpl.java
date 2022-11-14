package com.zq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zq.dao.BaseDao;
import com.zq.dao.HouseBrokerDao;
import com.zq.entity.HouseBroker;
import com.zq.service.HouseBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 13:39
 * @Description: TODO
 */
@Service(interfaceClass = HouseBrokerService.class)
@Transactional
public class HouseBrokerServiceImpl extends BaseServiceImpl<HouseBroker> implements HouseBrokerService {

    @Autowired
    private HouseBrokerDao houseBrokerDao;

    @Override
    protected BaseDao<HouseBroker> getEntityDao() {
        return houseBrokerDao;
    }


    @Override
    public List<HouseBroker> getHouseBrokerByHouseId(Integer houseId) {
        return houseBrokerDao.getHouseBrokerByHouseId(houseId);
    }
}
