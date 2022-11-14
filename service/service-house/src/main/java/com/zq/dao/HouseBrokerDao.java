package com.zq.dao;

import com.zq.entity.HouseBroker;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 13:37
 * @Description: TODO
 */
public interface HouseBrokerDao extends BaseDao<com.zq.entity.HouseBroker> {
    // 根据房源id查询房源经纪人
    List<HouseBroker> getHouseBrokerByHouseId(Integer houseId);
}
