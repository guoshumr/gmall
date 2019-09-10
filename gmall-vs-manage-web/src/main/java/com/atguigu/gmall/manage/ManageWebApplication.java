package com.atguigu.gmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author gool
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu.gmall.manage.controller","com.atguigu.gmall.utilweb.utils"})
public class ManageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageWebApplication.class, args);
    }

}
