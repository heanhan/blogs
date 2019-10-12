package com.zhaojh.blogs.controller;

import com.zhaojh.blogs.pojo.User;
import com.zhaojh.blogs.service.IUserService;
import com.zhaojh.blogs.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Slf4j
@Controller
@RequestMapping(value = "/logInOut")
public class LoginOutController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private IUserService userService;

    /**
     * 用户的账号的唯一性校验
     * @param account 账号
     * @return success/fail
     */
    @PostMapping(value = "/uniqueAccountValidate")
    @ResponseBody
    public String uniqueAccountValidate(String account){
        String isUse = userService.uniqueAccount(account);
        return isUse;
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping(value = "/registerUserInfo")
    @ResponseBody
    public String registerUserInfo(User user){

        String id=idWorker.nextId()+"";//主键
        user.setId(id);
        if(user.getPassword()!=null&&!"".equals(user.getPassword())){
            String password = bCryptPasswordEncoder.encode(user.getPassword());//加密后的密码
            user.setPassword(password);//设置密码
        }
        return userService.register(user);
    }

    /**
     * 跳转到登录界面
     * @return
     */
    @GetMapping(value = "/login")
    public String login(){
        return "/login.html";
    }

    /**
     * 用户登录模块
     * @param accoount  账号
     * @param password 密码
     * @return user
     */
    @PostMapping(value = "/userLoginInfo")
    public String userLoginInfo(@RequestParam(required = false) String accoount,@RequestParam(required = false) String phone_number, @RequestParam(required = false)String password){
        //用户登录 先根据用户名判断当前用户是否存在
        User user = userService.findByAccount(accoount, phone_number);//根据账号或者手机号进行用户查询是否存在
        boolean matches = bCryptPasswordEncoder.matches(password, user.getPassword());//参数一：用户输入的密码；参数二查询的密码进行比对。
        if(matches){
            log.info("用户登录成功！");
            request.getSession().setAttribute("account",user.getAccount());
            return "index.html";
        }
        log.info("用户登录失败！");
        return null;
    }

}
