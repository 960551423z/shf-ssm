package com.zq.service;


import com.github.pagehelper.PageInfo;
import com.zq.entity.Community;

import java.util.List;
import java.util.Map;


/**
 * @Author: 阿庆
 * @Date: 2022/11/11 14:23
 * @Description: TODO
 */
public interface CommunityService extends BaseService<Community> {

    List<Community> findAll();
}
