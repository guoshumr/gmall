package com.atguigu.gmall.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author goolearn
 * @date 2019/9/6 20:55
 */
@Controller
@CrossOrigin
public class ManageController {

    @GetMapping(value = {"/","index"})
    public String toIndex(){
        return "index";
    }

}
