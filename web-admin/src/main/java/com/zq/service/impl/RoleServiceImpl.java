package com.zq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zq.dao.BaseDao;
import com.zq.dao.RoleDao;
import com.zq.entity.Role;
import com.zq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/3 20:39
 * @Description: TODO
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired(required = false)
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    protected BaseDao<Role> getEntityDao() {
        return roleDao;
    }

}
