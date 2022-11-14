package com.zq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zq.dao.BaseDao;
import com.zq.dao.RoleDao;
import com.zq.entity.Role;
import com.zq.service.RoleService;
import com.zq.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/3 20:39
 * @Description: TODO
 */
@Service(interfaceClass = RoleService.class)
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired(required = false)
    private RoleDao roleDao;


    @Override
    protected BaseDao<Role> getEntityDao() {
        return roleDao;
    }

}
