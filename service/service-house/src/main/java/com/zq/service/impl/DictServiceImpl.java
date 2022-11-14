package com.zq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zq.dao.DictDao;
import com.zq.entity.Dict;
import com.zq.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 阿庆
 * @Date: 2022/11/11 10:37
 * @Description: TODO
 */
@Service(interfaceClass = DictService.class)
@Transactional
public class DictServiceImpl implements DictService{

    @Autowired
    private DictDao dictDao;

    @Override
    public List<Map<String, Object>> findZnodes(Long id) {
        // 根据父 id 查询该节点下的所有子节点
        List<Dict> dictList = dictDao.findListByParentId(id);

        // 创建返回的 list
        List<Map<String,Object>> zNodes = new ArrayList<>();

        // 遍历 dictList
        for (Dict dict : dictList) {
            // 返回数据格式，[{ id:'01',	name:'n1',	isParent:true},xxxx]
            // 创建一个Map
            Map<String,Object> map = new HashMap<>();
            map.put("id",dict.getId());
            map.put("name",dict.getName());

            // 调用 DictDao 中判断该节点是否有父节点
            Integer count = dictDao.isParentNode(dict.getId());
            map.put("isParent",count > 0 ? true : false);
            zNodes.add(map);
        }

        return zNodes;
    }

    @Override
    public List<Dict> findListByParentId(Long parentId) {
        return dictDao.findListByParentId(parentId);
    }

    @Override
    public List<Dict> findListByDictCode(String dictCode) {
        Dict dict = dictDao.findDictByDictCode(dictCode);

        // 根据当前对象的 id 找到所有的子节点
        List<Dict> list = this.findListByParentId(dict.getId());
        return list;
    }
}
