package com.zhaojh.blogs.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 普通用户
 */
@Data
@Entity
@Table(name = "blog_user")
public class User {
    @Id
    @Column(name = "id")
    private String id;//主键

    @Column(name = "nick_name")
    private String nickName;//昵称

    @Column(name = "head_photo")
    private String headPhoto;//头像

    @Column(name = "account")
    private String account;//登录账号

    @Column(name = "password")
    private String password;//密码

    @Column(name = "real_name")
    private String realName;//真是姓名

    @Column(name = "id_card")
    private String idCard;//身份证号码

    @Column(name = "phone_number")
    private String phoneNumber;//手机号码


}
