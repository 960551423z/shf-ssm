package com.zq.service;

import com.zq.entity.Dict;

import java.util.List;
import java.util.Map;

/**
 * @Author: 阿庆
 * @Date: 2022/11/11 10:36
 * @Description: TODO
 */
public interface DictService {

    // 查询数据字典中的数据，通过 zTree 进行渲染
    List<Map<String, Object>> findZnodes(Long id);


    // 根据 父id 获取该节点下的所有节点
    List<Dict> findListByParentId(Long parentId);

    // 根据编码获取该节点下的所有节点
    List<Dict> findListByDictCode(String dictCode);
}
