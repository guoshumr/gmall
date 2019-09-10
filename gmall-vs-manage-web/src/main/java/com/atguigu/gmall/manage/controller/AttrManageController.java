package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.service.ManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/7 17:19
 */
@RestController
@CrossOrigin
public class AttrManageController {

    @Reference
    private ManageService manageService;

    @PostMapping("getCatalog1")
    public List<BaseCatalog1> getCatalog1(){
        return  manageService.listBaseCatalog1();
    }

    @PostMapping("getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        return  manageService.listBaseCatalog2ByCatalog1Id(catalog1Id);
    }

    @PostMapping("getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return  manageService.listBaseCatalog3ByCatalog2Id(catalog2Id);
    }

    @GetMapping("attrInfoList")
    public List<BaseAttrInfo> getBaseAttrInfo(String catalog3Id){
        return  manageService.listBaseAttrInfoByCatalog3Id(catalog3Id);
    }

    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
    }

    @RequestMapping("getAttrValueList")
    public List<BaseAttrValue> getAttrValueList(String attrId){
        return manageService.getAttrValueList(attrId).getAttrValues();
    }
}
