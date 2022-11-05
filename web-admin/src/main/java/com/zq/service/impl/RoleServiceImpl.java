package com.zq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Integer insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public void delete(Integer id) {
        roleDao.delete(id);
    }

    @Override
    public Role getById(Integer id) {
        return roleDao.getById(id);
    }

    @Override
    public Integer update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public PageInfo<Role> findByPageAndLike(Integer pageNum, Integer pageSize,Role role) {
        // 开启分页查询
        PageHelper.startPage(pageNum,pageSize);


        List<Role> list = roleDao.findByPageAndLike(pageNum, pageSize,role);

        return new PageInfo<>(list);
    }


}
