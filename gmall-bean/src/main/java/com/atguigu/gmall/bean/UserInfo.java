package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author goolearn
 * @date 2019/9/4 18:43
 */
@Data
public class UserInfo implements Serializable {

    @Id // 表示注解
    @Column // 普通的字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 表示获取主键自增 mysql=GenerationType.IDENTITY oracle = GenerationType.AUTO
    private String id;
    @Column
    private String loginName;
    @Column
    private String nickName;
    @Column
    private String passwd;
    @Column
    private String name;
    @Column
    private String phoneNum;
    @Column
    private String email;
    @Column
    private String headImg;
    @Column
    private String userLevel;
}
