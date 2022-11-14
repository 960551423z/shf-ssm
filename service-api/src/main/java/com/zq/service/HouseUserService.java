package com.zq.service;

import com.zq.entity.HouseUser;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 14:44
 * @Description: TODO
 */
public interface HouseUserService extends BaseService<HouseUser>{
    // 根据 id 查询房东信息
    List<HouseUser> getHouseUsersByHouseId(Integer houseId);
}
