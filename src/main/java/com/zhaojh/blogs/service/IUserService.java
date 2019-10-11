package com.zhaojh.blogs.service;

import com.zhaojh.blogs.pojo.User;

public interface IUserService {


    /**
     * 用户的账号的唯一性校验
     * @param account 账号
     * @return success/fail
     */
    String uniqueAccount(String account);

    /**
     * 用户注册
     * @param user 用户
     * @return string
     */
    String register(User user);

    /**
     * 查询用户是否存在，可以是account、手机号
     * @param account 用户账号
     * @param phone_number 用户手机号
     * @return user
     */
    User findByAccount(String account, String phone_number);

    /**
     * 用户登录
     * @param account 账号
     * @param password 密码
     * @return user
     */
    User loginUserInfo(String account, String password);
}
