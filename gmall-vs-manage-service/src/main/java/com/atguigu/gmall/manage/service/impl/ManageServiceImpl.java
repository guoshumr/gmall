package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/7 11:11
 */
@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;

    @Autowired
    BaseCatalog1Mapper baseCatalog1Mapper;

    @Autowired
    BaseCatalog2Mapper baseCatalog2Mapper;

    @Autowired
    BaseCatalog3Mapper baseCatalog3Mapper;

    @Override
    public List<BaseCatalog1> listBaseCatalog1() {
        return baseCatalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> listBaseCatalog2ByCatalog1Id(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        return baseCatalog2Mapper.select(baseCatalog2);
    }

    @Override
    public List<BaseCatalog3> listBaseCatalog3ByCatalog2Id(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        return baseCatalog3Mapper.select(baseCatalog3);
    }

    @Override
    public List<BaseAttrInfo> listBaseAttrInfoByCatalog3Id(String catalog3Id) {

        List<BaseAttrInfo> attrInfos = baseAttrInfoMapper.getAttrInfoListByCatalog3Id(catalog3Id);
        System.out.println("===========");
        for (BaseAttrInfo attrInfo : attrInfos) {
            System.out.println("attrInfo:" + attrInfo);
        }
        return attrInfos;
    }

    @Override
    public BaseAttrInfo getAttrValueList(String attrId) {
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        List<BaseAttrValue> attrValues = baseAttrValueMapper.select(baseAttrValue);
        baseAttrInfo.setAttrValues(attrValues);
        return baseAttrInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if (baseAttrInfo == null) {
            return;
        }
        if (baseAttrInfo.getId() == null) {
            baseAttrInfoMapper.insert(baseAttrInfo);
        } else {
            baseAttrInfoMapper.updateByPrimaryKey(baseAttrInfo);
        }
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValue);

        List<BaseAttrValue> attrValues = baseAttrInfo.getAttrValues();
        if (attrValues == null || attrValues.size() < 1) {
            return;
        }
        for (BaseAttrValue attrValue : attrValues) {
            attrValue.setAttrId(baseAttrInfo.getId());
            attrValue.setId(null);
            baseAttrValueMapper.insert(attrValue);
        }
    }
}
