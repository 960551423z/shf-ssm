package com.zq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zq.dao.BaseDao;
import com.zq.dao.HouseImageDao;
import com.zq.entity.HouseImage;
import com.zq.service.HouseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 14:47
 * @Description: TODO
 */
@Service (interfaceClass = HouseImageService.class)
@Transactional
public class HouseImageServiceImpl extends BaseServiceImpl<HouseImage> implements HouseImageService {

    @Autowired
    private HouseImageDao houseImageDao;

    @Override
    protected BaseDao<HouseImage> getEntityDao() {
        return houseImageDao;
    }

    @Override
    public List<HouseImage> getHouseImageByHouseIdAndType(Integer houseId, Integer type) {
        return houseImageDao.getHouseImageByHouseIdAndType(houseId,type);
    }
}
