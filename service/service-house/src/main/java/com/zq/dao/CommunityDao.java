package com.zq.dao;

import com.github.pagehelper.Page;
import com.zq.entity.Community;

import java.util.List;
import java.util.Map;

/**
 * @Author: 阿庆
 * @Date: 2022/11/11 14:18
 * @Description: TODO
 */
public interface CommunityDao extends BaseDao<Community> {
    @Override
    Page<Community> findByPageAndLike(Map<String, Object> filters);

    List<Community> findAll();
}
