package com.zq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zq.dao.BaseDao;
import com.zq.service.BaseService;
import com.zq.util.CastUtil;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author: 阿庆
 * @Date: 2022/11/5 11:44
 * @Description: TODO
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseDao<T> getEntityDao();

    @Override
    public Integer insert(T t) {
        return getEntityDao().insert(t);
    }

    @Override
    public void delete(Serializable id) {
        getEntityDao().delete(id);
    }

    @Override
    public T getById(Serializable id) {
        return getEntityDao().getById(id);
    }

    @Override
    public Integer update(T t) {

        return getEntityDao().update(t);
    }

    @Override
    public PageInfo<T> findByPageAndLike(Map<String, Object> filters) {
        //当前页数
        int pageNum = CastUtil.castInt(filters.get("pageNum"), 1);

        //每页显示的记录条数
        int pageSize = CastUtil.castInt(filters.get("pageSize"), 3);

        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<T>(getEntityDao().findByPageAndLike(filters), 5);
    }
}
