package com.zq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.zq.entity.Community;
import com.zq.entity.Dict;
import com.zq.service.CommunityService;
import com.zq.service.DictService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: 阿庆
 * @Date: 2022/11/11 14:31
 * @Description: TODO
 */
@Controller
@RequestMapping("/community")
public class CommunityController extends BaseController {


    private final static String SUCCESS_PAGE = "community/index";
    private final static String REDIRECT_CREATE = "community/create";
    private final static String REDIRECT_EDIT = "community/edit";
    private final static String HANDLE_SUCCESS = "common/successPage";
    private final static String REDIRECT_COMMUNITY = "redirect:/community";

    @Reference
    private CommunityService communityService;


    @Reference
    private DictService dictService;


    /**
     * 分页查询
     * @param model
     * @param request
     * @return
     */
    @RequestMapping
    public String index(Model model,HttpServletRequest request) {

        // 获取请求的参数
        Map<String,Object> filters = getFilters(request);

        // 获取分页，放入 model 中
        PageInfo<Community> pageInfo = communityService.findByPageAndLike(filters);


        // 根据编码获取 beijing 所有的区
        List<Dict> areaList = dictService.findListByDictCode("beijing");

        // 将 filters 放入 request 域中
        model.addAttribute("filters",filters);
        model.addAttribute("page",pageInfo);
        model.addAttribute("areaList",areaList);

        return SUCCESS_PAGE;
    }


    /**
     * 进入创建的页面
     * @param model
     * @return
     */
    @RequestMapping("/create")
    public String goCreate(Model model) {
        // 根据编码获取 beijing 所有的区
        List<Dict> areaList = dictService.findListByDictCode("beijing");

        model.addAttribute("areaList",areaList);
        return REDIRECT_CREATE;
    }

    /**
     * 进行添加
     * @param community
     * @return
     */
    @PostMapping("/save")
    public String save(Community community) {

        // 插入数据
        communityService.insert(community);

        return HANDLE_SUCCESS;
    }

    /**
     * 进入修改
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String getById(@PathVariable("id") Integer id,Model model) {

        Community community = communityService.getById(id);

        List<Dict> areaList = dictService.findListByDictCode("beijing");

        model.addAttribute("community",community);

        model.addAttribute("areaList",areaList);
        return REDIRECT_EDIT;
    }

    /**
     * 保存修改
     * @param community
     * @return
     */
    @PostMapping("/update")
    public String update(Community community) {
        communityService.update(community);
        return HANDLE_SUCCESS;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        communityService.delete(id);
        return REDIRECT_COMMUNITY;
    }
}
