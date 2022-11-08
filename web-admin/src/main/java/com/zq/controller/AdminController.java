package com.zq.controller;

import com.github.pagehelper.PageInfo;
import com.zq.entity.Admin;
import com.zq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: 阿庆
 * @Date: 2022/11/5 12:41
 * @Description: TODO
 */
@Controller
@RequestMapping("admin")
public class AdminController {


    private final static String SUCCESS_PAGE= "common/successPage";

    @Autowired
    private AdminService adminService;

    @RequestMapping("/create")
    public String create() {
        return "admin/create";
    }



    @RequestMapping("/{pageNum}")
    public String finByPageAndLike(@PathVariable("pageNum") Integer pageNum, Model model, Admin admin,
                                   HttpServletRequest request,
                                   String createTimeBegin,
                                   String createTimeEnd) {

        Integer pageSize = 3;

        PageInfo<Admin> page = adminService.findByPageAndLike(pageNum, pageSize, admin,createTimeBegin,createTimeEnd);

        model.addAttribute("page",page);

        return "admin/index";
    }



    @RequestMapping("/save")
    public String save(Admin admin) {
        adminService.insert(admin);
        return SUCCESS_PAGE;
    }


    // 修改（1）：先查询回显
    @RequestMapping("/edit/{id}")
    public String getById(@PathVariable("id") Integer id,Model model) {
        Admin admin = adminService.getById(id);

        model.addAttribute("admin",admin);

        return "admin/edit";
    }

    //修改（2）： 更新
    @RequestMapping("/update")
    public String update(Admin admin) {
        adminService.update(admin);

        return SUCCESS_PAGE;
    }

    // 删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        adminService.delete(id);
        return "redirect:/admin/1";
    }
}
