package com.zq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zq.dao.BaseDao;
import com.zq.dao.DictDao;
import com.zq.dao.HouseDao;
import com.zq.entity.House;
import com.zq.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @Author: 阿庆
 * @Date: 2022/11/12 19:07
 * @Description: TODO
 */
@Service(interfaceClass = HouseService.class)
@Transactional
public class HouseServiceImpl extends BaseServiceImpl<House> implements HouseService {

    @Autowired
    private HouseDao houseDao;

    @Autowired
    private DictDao dictDao;

    @Override
    protected BaseDao<House> getEntityDao() {
        return houseDao;
    }

    /**
     * 因为查询的是 数字，要将数字转换成字符串
     * @param id
     * @return
     */
    @Override
    public House getById(Serializable id) {
        House house = houseDao.getById(id);
        // 获取户型
        String houseTypeName = dictDao.getNameById(house.getHouseTypeId());
        //获取楼层
        String floorName = dictDao.getNameById(house.getFloorId());
        // 获取朝向
        String directionName = dictDao.getNameById(house.getDirectionId());
        // 获取建筑结构
        String buildStructureName = dictDao.getNameById(house.getBuildStructureId());
        // 获取装修情况
        String decorationName = dictDao.getNameById(house.getDecorationId());
        // 获取房屋用途
        String houseUseName = dictDao.getNameById(house.getHouseUseId());
        // 设置
        house.setHouseTypeName(houseTypeName);
        house.setFloorName(floorName);
        house.setDirectionName(directionName);
        house.setBuildStructureName(buildStructureName);
        house.setDecorationName(decorationName);
        house.setHouseUseName(houseUseName);

        return house;
    }

    @Override
    public void publish(Long id, Integer status) {
        House house = new House();
        house.setId(id);
        house.setStatus(status);
        houseDao.update(house);
    }



}
