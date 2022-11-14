package com.zq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zq.dao.AdminDao;
import com.zq.dao.BaseDao;
import com.zq.entity.Admin;
import com.zq.service.AdminService;
import com.zq.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/5 12:43
 * @Description: TODO
 */
@Service(interfaceClass = AdminService.class)
@Transactional
public  class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;

    @Override
    protected BaseDao<Admin> getEntityDao() {
        return adminDao;
    }


    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }
}
