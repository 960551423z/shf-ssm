package com.zq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zq.entity.HouseUser;

import com.zq.service.HouseUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 阿庆
 * @Date: 2022/11/13 16:31
 * @Description: TODO
 */
@Controller
@RequestMapping("/houseUser")
public class HouseUserController extends BaseController{


    @Reference
    private HouseUserService houseUserService;

    private final static String PAGE_CREATE = "houseUser/create";
    private final static String PAGE_SUCCESS = "common/successPage";
    private final static String PAGE_EDIT = "houseUser/edit";
    private final static String LIST_ACTION = "redirect:/house/";


    /**
     * 进入新增
     * @param model
     * @param houseId
     * @return
     */
    @GetMapping("/create")
    public String create(Model model, @RequestParam("houseId") Integer houseId) {
        model.addAttribute("houseId",houseId);
        return PAGE_CREATE;
    }


    /**
     * 保存新增
     * @param houseUser
     * @return
     */
    @PostMapping("/save")
    public String save(HouseUser houseUser) {
        houseUserService.insert(houseUser);
        return PAGE_SUCCESS;
    }

    /**
     * 进入编辑页面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") Long id) {
        HouseUser houseUser = houseUserService.getById(id);
        model.addAttribute("houseUser",houseUser);
        return PAGE_EDIT;
    }

    /**
     * 更新
     * @param houseUser
     * @return
     */
    @PostMapping("/update")
    public String update(HouseUser houseUser) {
        houseUserService.update(houseUser);
        return PAGE_SUCCESS;
    }


    /**
     * 删除
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete/{houseId}/{id}")
    public String delete(@PathVariable Long houseId, @PathVariable Long id) {
        houseUserService.delete(id);
        return LIST_ACTION + houseId;
    }


}
