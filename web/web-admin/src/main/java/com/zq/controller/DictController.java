package com.zq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zq.entity.Dict;
import com.zq.result.Result;
import com.zq.service.DictService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: 阿庆
 * @Date: 2022/11/11 10:35
 * @Description: TODO
 */
@Controller
@RequestMapping("/dict")
public class DictController {

    private final static String SUCCESS_PAGE = "dict/index";

    @Reference
    private DictService dictService;

    // 展示字典的页面
    @RequestMapping
    public String index() {
        return SUCCESS_PAGE;
    }

    // 获取字典中的数据
    @ResponseBody
    @RequestMapping("/findZnodes")
    public Result findZnodes(@RequestParam(value = "id",defaultValue = "0") Long id) {
        List<Map<String,Object>> zNodes = dictService.findZnodes(id);
        return Result.ok(zNodes);
    }

    // 根据框中的选择进行查询
    @ResponseBody
    @GetMapping("/findListByParentId/{areaId}")
    public Result findListByParentId(@PathVariable("areaId") Long areaId) {
        List<Dict> listByParentId = dictService.findListByParentId(areaId);
        return Result.ok(listByParentId);
    }

}
