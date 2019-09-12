package com.zhaojh.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : zhaojh
 * @date : 2019-09-12
 * @function :
 */

@Controller
public class PageController {

    @GetMapping(value = "/page")
    public String page(){
        return "/page.html";
    }
}
