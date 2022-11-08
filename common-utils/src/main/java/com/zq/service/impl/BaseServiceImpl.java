package com.zq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zq.dao.BaseDao;
import com.zq.service.BaseService;

import java.io.Serializable;
import java.util.List;

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
    public PageInfo<T> findByPageAndLike(Integer pageNum, Integer pageSize, T t) {
        // 开启分页查询
        PageHelper.startPage(pageNum,pageSize);

       List<T> list = getEntityDao().findByPageAndLike(pageNum, pageSize, t);

        return new PageInfo<>(list);
    }
}
