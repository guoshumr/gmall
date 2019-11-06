package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.spu.BaseSaleAttr;
import com.atguigu.gmall.manage.mapper.BaseSaleAttrMapper;
import com.atguigu.gmall.service.BaseSaleAttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/8 20:54
 */
@Service
public class BaseSaleAttrServiceImpl implements BaseSaleAttrService {
    @Autowired
    private BaseSaleAttrMapper baseSaleAttrMapper;
    @Override
    public List<BaseSaleAttr> baseSaleAttrList() {
    	//测试一下AA
        return baseSaleAttrMapper.selectAll();
    }
}
