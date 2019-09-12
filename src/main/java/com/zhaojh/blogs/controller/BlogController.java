package com.zhaojh.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : zhaojh
 * @date : 2019-09-12
 * @function :
 */

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    /**
     * 测试控制流程
     */
    @GetMapping(value = "/index")
    public String index(){

        return "/index.html";

    }
}
