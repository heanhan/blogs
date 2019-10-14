package com.zhaojh.blogs.controller;

import com.zhaojh.blogs.service.IPersonalNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhaojh
 * @date : 2019-10-14
 * @function : 个人网站的所有的公共的部分
 */

@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private IPersonalNotesService personalNotesService;


    /**
     * 统计各类的 随记 技术贴的数量。
     * @return
     */
    @GetMapping(value = "/countAllCategoryNumbers")
    public Map<String,String> countAllCategoryNumbers(){
        Map<String,String> result =new HashMap<>();
        String personalNotesNumber = personalNotesService.countPersonalNotes()+"";//统计个人随记的数量
        //统计技术贴的数量
        //统计生活的数量
        result.put("personalNotesNumber",personalNotesNumber);

        return null;

    }
}
