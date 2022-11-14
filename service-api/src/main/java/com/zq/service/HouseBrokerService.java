package com.zq.service;

import com.zq.entity.HouseBroker;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 13:39
 * @Description: TODO
 */
public interface HouseBrokerService extends BaseService<HouseBroker> {
    // 根据房源id查询房源经纪人
    List<HouseBroker> getHouseBrokerByHouseId(Integer id);
}
