package com.zq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.zq.entity.*;
import com.zq.entity.HouseBroker;
import com.zq.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 9:15
 * @Description: TODO
 */
@Controller
@RequestMapping("/house")
public class HouseController extends BaseController {

    private final static String INDEX_PAGE = "house/index";
    private final static String PAGE_CREATE = "house/create";
    private final static String PAGE_SUCCESS = "common/successPage";
    private final static String PAGE_EDIT = "house/edit";
    private final static String LIST_ACTION = "redirect:/house";
    private final static String DETAIL_PAGE = "house/show";


    @Reference
    private HouseService houseService;

    @Reference
    private CommunityService communityService;

    @Reference
    private DictService dictService;


    @Reference
    private HouseUserService houseUserService;

    @Reference
    private HouseImageService houseImageService;


    @Reference
    private HouseBrokerService houseBrokerService;

    /**
     * 获取所有小区及数据字典中的数据，并放入 Model 中
     * @param model
     */
    public void setRequestAttribute(Model model) {
        // 查询所有小区
        List<Community> communityList = communityService.findAll();
        // 获取户型
        List<Dict> houseTypeList = dictService.findListByDictCode("houseType");
        // 获取楼层
        List<Dict> floorList = dictService.findListByDictCode("floor");
        // 获取建筑结构
        List<Dict> buildStructureList = dictService.findListByDictCode("buildStructure");
        // 获取朝向
        List<Dict> directionList = dictService.findListByDictCode("direction");
        // 获取装修情况
        List<Dict> decorationList = dictService.findListByDictCode("decoration");
        // 获取房屋用途
        List<Dict> houseUseList = dictService.findListByDictCode("houseUse");

        // 将查询的数据放入域中
        model.addAttribute("communityList",communityList);
        model.addAttribute("houseTypeList",houseTypeList);
        model.addAttribute("floorList",floorList);
        model.addAttribute("buildStructureList",buildStructureList);
        model.addAttribute("directionList",directionList);
        model.addAttribute("decorationList",decorationList);
        model.addAttribute("houseUseList",houseUseList);
    }


    /**
     * 分页查询
     * @param model 将查询出来的结果放入域中
     * @param request 获取请求参数
     * @return
     */
    @RequestMapping
    public String index(Model model, HttpServletRequest request) {
        // 获取请求参数
        Map<String, Object> filters = getFilters(request);

        // 将请求参数放入域中
        model.addAttribute("filters",filters);

        // 分页查询
        PageInfo<House> page = houseService.findByPageAndLike(filters);

        // 将查询结果放入域中
        model.addAttribute("page",page);


        setRequestAttribute(model);


        return INDEX_PAGE;
    }

    /**
     * 进入新增
     * @param model
     * @return
     */
    @GetMapping("/create")
    public String create(Model model) {
        // 得到数据
        setRequestAttribute(model);
        return PAGE_CREATE;
    }

    /**
     * 保存新增
     * @param house
     * @return
     */
    @PostMapping("/save")
    public String save(House house) {
        houseService.insert(house);
        return PAGE_SUCCESS;
    }

    /**
     * 进入修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model) {

        // 查询进行渲染
        House house = houseService.getById(id);
        model.addAttribute("house",house);

        // 得到数据
        setRequestAttribute(model);

        return PAGE_EDIT;
    }

    /**
     * 保存更新
     * @param house
     * @return
     */
    @PostMapping("/update")
    public String update(House house) {

        houseService.update(house);

        return PAGE_SUCCESS;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        houseService.delete(id);
        return LIST_ACTION;
    }

    /**
     * 更新发布状态
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/publish/{id}/{status}")
    public String publish(@PathVariable Long id,@PathVariable Integer status) {
        houseService.publish(id, status);
        return LIST_ACTION;
    }

    /**
     * 查看房源详情
     * @param houseId
     * @return
     */
    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Integer houseId,Model model) {
        // 获取小区信息
        House house = houseService.getById(houseId);

        // 获取数据字典
        Community community = communityService.getById(house.getCommunityId());


        // 查询房源图片
        List<HouseImage> houseImageList1 = houseImageService.getHouseImageByHouseIdAndType(houseId, 1);

        // 查询房产图片
        List<HouseImage> houseImageList2 = houseImageService.getHouseImageByHouseIdAndType(houseId, 2);

        // 查询经纪人
        List<HouseBroker> houseBrokerList = houseBrokerService.getHouseBrokerByHouseId(houseId);

        // 查询房东
        List<HouseUser> houseUsersList = houseUserService.getHouseUsersByHouseId(houseId);


        model.addAttribute("house",house);
        model.addAttribute("community",community);

        model.addAttribute("houseBrokerList",houseBrokerList);
        model.addAttribute("houseUserList",houseUsersList);
        model.addAttribute("houseImage1List",houseImageList1);
        model.addAttribute("houseImage2List",houseImageList2);
        return DETAIL_PAGE;
    }
}
