package com.zq.service;

import com.zq.entity.Admin;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/5 12:42
 * @Description: TODO
 */
public interface AdminService extends BaseService<Admin> {
    List<Admin> findAll();
}
