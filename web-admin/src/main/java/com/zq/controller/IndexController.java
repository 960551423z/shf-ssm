package com.zq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 阿庆
 * @Date: 2022/11/3 22:42
 * @Description: TODO
 */
@Controller
public class IndexController {


    @RequestMapping("/")
    public String index() {
        return "frame/index";
    }

    @RequestMapping("/main")
    public String main() {
        return "frame/main";
    }

}
