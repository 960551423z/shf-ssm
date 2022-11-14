package com.zq.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author: 阿庆
 * @Date: 2022/11/5 10:07
 * @Description: TODO
 */
public interface BaseDao<T> {
    /**
     * 保存一个实体
     *
     * @param t
     */
    Integer insert(T t);

    /**
     * 删除
     *
     * @param id 标识ID 可以是自增长ID，也可以是唯一标识。
     */
    void delete(Serializable id);

    /**
     * 通过一个标识ID 获取一个唯一实体
     *
     * @param id 标识ID 可以是自增长ID，也可以是唯一标识。
     * @return
     */
    T getById(Serializable id);

    /**
     * 更新一个实体
     *
     * @param t
     */
    Integer update(T t);

    // 分页查询，条件查询
//    List<T> findByPageAndLike(Serializable pageNum, Serializable pageSize, @Param("t") T t);

    Page<T> findByPageAndLike(Map<String, Object> filters);

}
