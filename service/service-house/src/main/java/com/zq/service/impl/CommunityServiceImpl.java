package com.zq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zq.dao.BaseDao;
import com.zq.dao.CommunityDao;
import com.zq.dao.DictDao;
import com.zq.entity.Community;
import com.zq.service.CommunityService;
import com.zq.util.CastUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author: 阿庆
 * @Date: 2022/11/11 14:25
 * @Description: TODO
 */
@Service(interfaceClass = CommunityService.class)
@Transactional
public class CommunityServiceImpl extends BaseServiceImpl<Community> implements CommunityService {


    @Autowired
    private CommunityDao communityDao;

    @Autowired
    private DictDao dictDao;

    @Override
    protected BaseDao<Community> getEntityDao() {
        return communityDao;
    }

    /**
     * 将数字转换成字符串
     * @param id
     * @return
     */
    @Override
    public Community getById(Serializable id) {
        Community community = communityDao.getById(id);

        // 根据区域 id 获取名字
        String areaName = dictDao.getNameById(community.getAreaId());

        // 根据板块 id 获取名字
        String plateName = dictDao.getNameById(community.getPlateId());

        community.setAreaName(areaName);
        community.setPlateName(plateName);

        return community;
    }


    // 重写是为了得到 板块和区域  的名字
    @Override
    public PageInfo<Community> findByPageAndLike(Map<String, Object> filters) {

        Page<Community> page = communityDao.findByPageAndLike(filters);

        for (Community community : page) {
            // 根据区域 id 获取名字
            String areaName = dictDao.getNameById(community.getAreaId());

            // 根据板块 id 获取名字
            String plateName = dictDao.getNameById(community.getPlateId());

            community.setAreaName(areaName);
            community.setPlateName(plateName);
        }

        return new PageInfo<>(page,5);
    }

    @Override
    public List<Community> findAll() {
        return communityDao.findAll();
    }
}
