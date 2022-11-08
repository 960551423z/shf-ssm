package com.zq.service;

import com.github.pagehelper.PageInfo;
import com.zq.entity.Admin;

/**
 * @Author: 阿庆
 * @Date: 2022/11/5 12:42
 * @Description: TODO
 */
public interface AdminService extends BaseService<Admin> {

    PageInfo<Admin> findByPageAndLike(Integer pageNum, Integer pageSize, Admin admin, String createTimeBegin,String createTimeEnd);

}
