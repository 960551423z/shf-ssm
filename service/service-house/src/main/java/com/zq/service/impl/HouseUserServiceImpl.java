package com.zq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zq.dao.BaseDao;
import com.zq.dao.HouseUserDao;
import com.zq.entity.House;
import com.zq.entity.HouseUser;
import com.zq.service.HouseService;
import com.zq.service.HouseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 14:48
 * @Description: TODO
 */
@Service (interfaceClass = HouseUserService.class)
@Transactional
public class HouseUserServiceImpl extends BaseServiceImpl<HouseUser> implements HouseUserService {

    @Autowired
    private HouseUserDao houseUserDao;


    @Override
    protected BaseDao<HouseUser> getEntityDao() {
        return houseUserDao;
    }

    @Override
    public List<HouseUser> getHouseUsersByHouseId(Integer houseId) {
        return houseUserDao.getHouseUsersByHouseId(houseId);
    }

}
