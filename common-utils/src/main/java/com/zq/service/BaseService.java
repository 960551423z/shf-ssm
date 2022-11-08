package com.zq.service;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;

/**
 * @Author: 阿庆
 * @Date: 2022/11/5 11:41
 * @Description: TODO
 */
public interface BaseService<T> {

    Integer insert(T t);

    void delete(Serializable id);

    T getById(Serializable id);

    Integer update(T t);

    PageInfo<T> findByPageAndLike(Integer pageNum, Integer pageSize, T t);
}
