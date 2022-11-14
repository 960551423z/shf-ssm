package com.zq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zq.entity.Admin;
import com.zq.entity.HouseBroker;
import com.zq.service.AdminService;
import com.zq.service.HouseBrokerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 13:36
 * @Description: TODO
 */
@Controller
@RequestMapping("/houseBroker")
public class HouseBrokerController {


    private final static String CREATE_PAGE = "houseBroker/create";
    private final static String HANDLE_SUCCESS = "common/successPage";
    private final static String PAGE_EDIT = "houseBroker/edit";
    private final static String LIST_ACTION = "redirect:/house/";



    @Reference
    private HouseBrokerService houseBrokerService;


    @Reference
    private AdminService adminService;

    /**
     * 去添加的页面
     * @return
     */
    @GetMapping("/create")
    public String create(@RequestParam("houseId") Integer houseId, Model model) {
        List<Admin> adminList =  adminService.findAll();
        System.out.println(adminList);
        model.addAttribute("adminList",adminList);
        model.addAttribute("houseId",houseId);
        return CREATE_PAGE;
    }


    /**
     * 新增
     * @param houseBroker
     * @return
     */
    @PostMapping("/save")
    public String save(HouseBroker houseBroker) {
        Admin admin = adminService.getById(houseBroker.getBrokerId());

        if (admin.getHeadUrl() != null) {
            houseBroker.setBrokerHeadUrl(admin.getHeadUrl());
        }
        houseBroker.setBrokerName(admin.getName());

        houseBrokerService.insert(houseBroker);
        return HANDLE_SUCCESS;
    }


    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") Integer id) {
        // 查询经纪人

        HouseBroker houseBroker = houseBrokerService.getById(id);

        List<Admin> adminList = adminService.findAll();

        model.addAttribute("adminList",adminList);
        model.addAttribute("houseBroker",houseBroker);
        return PAGE_EDIT;
    }


    /**
     * 保存更新
     * @param houseBroker
     * @return
     */
    @PostMapping(value="/update")
    public String update(HouseBroker houseBroker) {
        Admin admin = adminService.getById(houseBroker.getBrokerId());
        houseBroker.setBrokerName(admin.getName());
        houseBroker.setBrokerHeadUrl(admin.getHeadUrl());
        houseBrokerService.update(houseBroker);

        return HANDLE_SUCCESS;
    }

    /**
     * 删除
     * @param houseId
     * @param id
     * @return
     */
    @GetMapping("/delete/{houseId}/{id}")
    public String delete(@PathVariable("houseId") Long houseId, @PathVariable("id") Long id) {
        houseBrokerService.delete(id);
        return LIST_ACTION + houseId;
    }

}
