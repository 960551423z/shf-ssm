package com.zq.dao;

import com.zq.entity.HouseUser;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 14:38
 * @Description: TODO
 */
public interface HouseUserDao extends BaseDao<HouseUser>{

    // 根据 id 查询房东信息
    List<HouseUser> getHouseUsersByHouseId(Integer houseId);
}
