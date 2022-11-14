package com.zq.dao;

import com.zq.entity.Role;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/3 20:26
 * @Description: TODO
 */

public interface RoleDao extends BaseDao<Role> {
    // 查询所有角色
    List<Role> findAll();


}
