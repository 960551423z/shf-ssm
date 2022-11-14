package com.zq.dao;

import com.zq.entity.Dict;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/11 10:37
 * @Description: TODO
 */
public interface DictDao {
    // 根据 父id 获取该节点下的所有子节点
    List<Dict> findListByParentId(Long id);

    // 根据父 id 判断该节点是否为父节点
    Integer isParentNode(Long id);

    // 根据编码获取 Dict 对象
    Dict findDictByDictCode(String dictCode);

    // 根据 id 获取小区管理中的 板块和区域
    String getNameById(Long id);
}
