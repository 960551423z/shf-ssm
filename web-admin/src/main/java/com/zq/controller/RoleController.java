package com.zq.controller;

import com.github.pagehelper.PageInfo;
import com.zq.entity.Role;
import com.zq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 阿庆
 * @Date: 2022/11/3 20:44
 * @Description: TODO
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    public static final String SUCCESS_PAGE = "common/successPage";

    @Autowired
    private RoleService roleService;


    // 弹出添加框
    @RequestMapping("/create")
    public String goAddCreate() {
        return "role/create";
    }

    // 新增角色
    @RequestMapping("/save")
    public String Save(Role role) {
        roleService.insert(role);
        return SUCCESS_PAGE;
    }

    // 根据 id 删除角色
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        roleService.delete(id);
        return "redirect:/role";
    }

    // 修改：先查询，再回显，再更新
    @RequestMapping("/edit/{id}")
    public String goEdit(@PathVariable("id") Integer id,Model model) {
        // 查询用户
        Role role = roleService.getById(id);

        // 将 role 放入 Model 域中
        model.addAttribute("role",role);
        return "role/edit";
    }

    @RequestMapping("/update")
    public String update(Role role) {
        roleService.update(role);
        return SUCCESS_PAGE;
    }

    // 分页及其条件查询
    @RequestMapping("/{pageNum}")
    public String findByPageAndLike( @PathVariable Integer pageNum, Model model,Role role) {


        Integer pageSize = 3;
        PageInfo<Role> pageInfo = roleService.findByPageAndLike(pageNum, pageSize,role);

        System.out.println(pageInfo);

        model.addAttribute("page",pageInfo);
        return "role/index";
    }


}
