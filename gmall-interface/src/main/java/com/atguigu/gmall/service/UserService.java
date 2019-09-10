package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/4 18:54
 *
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return 用户信息列表
     */
    List<UserInfo> getUserList();

    /**
     * 根据用户ID查询用户地址
     * @param userId 用户ID
     * @return 用户地址列表
     */
    List<UserAddress> getUserAddressByUserId(String userId);
}
