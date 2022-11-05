package com.zq.dao;

import com.github.pagehelper.PageInfo;
import com.zq.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/3 20:26
 * @Description: TODO
 */

public interface RoleDao {
    // 查询所有角色
    List<Role> findAll();

    // 添加角色
    Integer insert(Role role);

    // 删除角色（本质将is_deleted设置为1）
    void delete(Integer id);

    Role getById(Integer id);

    // 更新
    Integer update(Role role);

    // 分页查询，条件查询
    List<Role> findByPageAndLike(Integer pageNum,Integer pageSize,@Param("role") Role role);
}
