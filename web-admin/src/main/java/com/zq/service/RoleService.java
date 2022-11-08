package com.zq.service;

import com.github.pagehelper.PageInfo;
import com.zq.entity.Role;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/3 20:39
 * @Description: TODO
 */
public interface RoleService extends BaseService<Role> {
    List<Role> findAll();
//
//    Integer insert(Role role);
//
//    void delete(Integer id);
//
//    Role getById(Integer id);
//
//    Integer update(Role role);
//
//    PageInfo<Role> findByPageAndLike(Integer pageNum,Integer pageSize,Role role);
}
