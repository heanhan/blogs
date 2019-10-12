package com.zhaojh.blogs.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhaojh
 * @date : 2019-10-12
 * @function : 个人随记
 */

@Data
@Entity
@Table(name = "personal_notes")
public class PersonalNotes implements Serializable {

    @Id
    @Column(name = "id")
    private String id;//主键

    @Column(name = "category")
    private String category;//分类

    @Column(name = "title")
    private String title;//标题

    @Column(name = "content")
    private String content;//内容

    @Column(name = "author")
    private String author;//作者

    @Column(name = "read_number")
    private String readNumber;//阅读量

    @Column(name = "praise")
    private String praise;//赞

    @Column(name = "create_time")
    private Date createTime;//创建时间

    @Column(name = "modify_time")
    private Date modifyTime;//最近修改时间


}
