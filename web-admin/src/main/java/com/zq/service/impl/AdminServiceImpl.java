package com.zq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zq.dao.AdminDao;
import com.zq.dao.BaseDao;
import com.zq.entity.Admin;
import com.zq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/5 12:43
 * @Description: TODO
 */
@Service

public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;

    @Override
    protected BaseDao<Admin> getEntityDao() {
        return adminDao;
    }


    @Override
    public PageInfo<Admin> findByPageAndLike(Integer pageNum, Integer pageSize, Admin admin, String createTimeBegin, String createTimeEnd) {

        PageHelper.startPage(pageNum,pageSize);

        List<Admin> list = adminDao.findByPageAndLike(pageNum, pageSize, admin, createTimeBegin, createTimeEnd);

        return new PageInfo<>(list);
    }
}
