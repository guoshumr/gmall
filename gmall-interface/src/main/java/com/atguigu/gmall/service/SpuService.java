package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.sku.SkuInfo;
import com.atguigu.gmall.bean.spu.SpuImage;
import com.atguigu.gmall.bean.spu.SpuInfo;
import com.atguigu.gmall.bean.spu.SpuSaleAttr;

import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/8 20:36
 */
public interface SpuService {
    /**
     * 根据类别ID获取SPU
     *
     * @param catalog3Id 三级类别ID
     * @return SPU信息
     */
    List<SpuInfo> spuList(String catalog3Id);

    /**
     * 保存spu信息
     *
     * @param spuInfo spu信息
     */
    void saveSpuInfo(SpuInfo spuInfo);

    /**
     * 查询spu销售属性
     * @param spuId spuId
     * @return spu销售属性集合
     */
    List<SpuSaleAttr> spuSaleAttrList(String spuId);

    /**
     * 查询spu图片集合
     * @param spuId spuId
     * @return spu图片集合
     */
    List<SpuImage> spuImageList(String spuId);

    /**
     * 保存sku信息
     * @param skuInfo sku参数
     */
    void saveSkuInfo(SkuInfo skuInfo);
}
