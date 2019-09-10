package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.spu.BaseSaleAttr;

import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/8 20:53
 */
public interface BaseSaleAttrService {

    /**
     * 获取所有销售属性信息
     * @return 销售属性列表
     */
    List<BaseSaleAttr> baseSaleAttrList();
}
