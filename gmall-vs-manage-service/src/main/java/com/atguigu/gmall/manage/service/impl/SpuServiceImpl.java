package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.sku.SkuAttrValue;
import com.atguigu.gmall.bean.sku.SkuImage;
import com.atguigu.gmall.bean.sku.SkuInfo;
import com.atguigu.gmall.bean.sku.SkuSaleAttrValue;
import com.atguigu.gmall.bean.spu.SpuImage;
import com.atguigu.gmall.bean.spu.SpuInfo;
import com.atguigu.gmall.bean.spu.SpuSaleAttr;
import com.atguigu.gmall.bean.spu.SpuSaleAttrValue;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.SpuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.print.DocFlavor;
import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/8 20:39
 */
@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    private SpuInfoMapper spuInfoMapper;
    @Autowired
    private SpuImageMapper spuImageMapper;
    @Autowired
    private SpuSaleAttrMapper spuSaleAttrMapper;
    @Autowired
    private SpuSaleAttrValueMapper spuSaleAttrValueMapper;
    @Autowired
    private SkuInfoMapper skuInfoMapper;
    @Autowired
    private SkuAttrValueMapper skuAttrValueMapper;
    @Autowired
    private SkuSaleAttrValueMapper skuSaleAttrValueMapper;
    @Autowired
    private SkuImageMapper skuImageMapper;


    @Override
    public List<SpuInfo> spuList(String catalog3Id) {
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        return spuInfoMapper.select(spuInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSpuInfo(SpuInfo spuInfo) {

        if (StringUtils.isEmpty(spuInfo.getId())) {
            spuInfoMapper.insert(spuInfo);
        } else {
            spuInfoMapper.updateByPrimaryKey(spuInfo);
        }

        String spuId = spuInfo.getId();
        SpuImage sImage = new SpuImage();
        sImage.setSpuId(spuId);
        spuImageMapper.delete(sImage);

        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        if (spuImageList != null && spuImageList.size() > 0) {
            for (SpuImage spuImage : spuImageList) {
                spuImage.setId(null);
                spuImage.setSpuId(spuId);
                spuImageMapper.insert(spuImage);
            }
        }

        SpuSaleAttr spuSaleAttr = new SpuSaleAttr();
        spuSaleAttr.setSpuId(spuId);
        spuSaleAttrMapper.delete(spuSaleAttr);

        SpuSaleAttrValue spuSaleAttrValue = new SpuSaleAttrValue();
        spuSaleAttrValue.setSpuId(spuId);
        spuSaleAttrValueMapper.delete(spuSaleAttrValue);

        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if (spuSaleAttrList == null || spuSaleAttrList.size() < 1) {
            return;
        }

        for (SpuSaleAttr saleAttr : spuSaleAttrList) {
            saleAttr.setId(null);
            saleAttr.setSpuId(spuId);
            spuSaleAttrMapper.insert(saleAttr);

            List<SpuSaleAttrValue> spuSaleAttrValueList = saleAttr.getSpuSaleAttrValueList();
            if (spuSaleAttrValueList == null || spuSaleAttrValueList.size() < 1) {
                return;
            }

            for (SpuSaleAttrValue saleAttrValue : spuSaleAttrValueList) {
                saleAttrValue.setId(null);
                saleAttrValue.setSpuId(spuId);
                spuSaleAttrValueMapper.insert(saleAttrValue);
            }
        }
    }

    @Override
    public List<SpuSaleAttr> spuSaleAttrList(String spuId) {

        List<SpuSaleAttr> spuSaleAttrList = spuSaleAttrMapper.getSpuSaleAttrList(spuId);
        System.out.println("===spuSaleAttrList===");
        for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {
            System.out.println("spuSaleAttr:" + spuSaleAttr);
        }
        return spuSaleAttrList;
    }

    @Override
    public List<SpuImage> spuImageList(String spuId) {
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuId);
        return spuImageMapper.select(spuImage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSkuInfo(SkuInfo skuInfo) {
        if (StringUtils.isEmpty(skuInfo.getId())) {
            skuInfoMapper.insert(skuInfo);
        } else {
            skuInfoMapper.updateByPrimaryKey(skuInfo);
        }
        String skuId = skuInfo.getId();

        SkuAttrValue skuAttrValue = new SkuAttrValue();
        skuAttrValue.setSkuId(skuId);
        skuAttrValueMapper.delete(skuAttrValue);

        List<SkuAttrValue> skuAttrValueList = skuInfo.getSkuAttrValueList();
        if(skuAttrValueList != null && skuAttrValueList.size() >0){
            for (SkuAttrValue attrValue : skuAttrValueList) {
                attrValue.setId(null);
                attrValue.setSkuId(skuId);
                skuAttrValueMapper.insert(attrValue);
            }
        }

        SkuSaleAttrValue skuSaleAttrValue = new SkuSaleAttrValue();
        skuSaleAttrValue.setSkuId(skuId);
        skuSaleAttrValueMapper.delete(skuSaleAttrValue);

        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        if(skuSaleAttrValueList != null && skuSaleAttrValueList.size() >0){
            for (SkuSaleAttrValue saleAttrValue : skuSaleAttrValueList) {
                saleAttrValue.setId(null);
                saleAttrValue.setSkuId(skuId);
                skuSaleAttrValueMapper.insert(saleAttrValue);
            }
        }

        SkuImage skuImage = new SkuImage();
        skuImage.setSkuId(skuId);
        skuImageMapper.delete(skuImage);

        List<SkuImage> skuImageList = skuInfo.getSkuImageList();
        if(skuImageList != null && skuImageList.size() > 0){
            for (SkuImage image : skuImageList) {
                image.setId(null);
                image.setSkuId(skuId);
                skuImageMapper.insert(image);
            }
        }
    }
}
