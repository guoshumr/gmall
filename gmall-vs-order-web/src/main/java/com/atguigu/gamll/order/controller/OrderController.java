package com.atguigu.gamll.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/6 19:37
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Reference
    private UserService userService;

    @GetMapping
    public String orderAddressByUserId(String userId){
        List<UserAddress> userAddressByUserId = userService.getUserAddressByUserId(userId);
        return JSON.toJSONString(userAddressByUserId);
    }
}
