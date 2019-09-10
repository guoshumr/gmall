package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.*;

import java.util.List;

/**
 * 后台管理服务接口
 *
 * @author goolearn
 * @date 2019/9/7 8:48
 */
public interface ManageService {

    /**
     * 查询所有一级类别信息集合
     * @return 一级类别信息
     */
    List<BaseCatalog1> listBaseCatalog1();


    /**
     * 根据一级类别ID查询所有二级类别信息集合
     * @param catalog1Id 一级类别ID
     * @return 二级类别信息
     */
    List<BaseCatalog2> listBaseCatalog2ByCatalog1Id(String catalog1Id);


    /**
     * 根据二级类别ID查询所有三级类别信息集合
     * @param catalog2Id 二级类别ID
     * @return 三级类别信息
     */
    List<BaseCatalog3> listBaseCatalog3ByCatalog2Id(String catalog2Id);


    /**
     * 根据级别ID查询所有属性信息集合
     * @param catalog3Id 三级类别ID
     * @return 属性信息
     */
    List<BaseAttrInfo> listBaseAttrInfoByCatalog3Id(String catalog3Id);


    /**
     * 根据属性ID查询属性值
     * @param attrId 属性ID
     * @return 返回属性值
     */
    BaseAttrInfo getAttrValueList(String attrId);

    /**
     * 保存属性值
     * @param baseAttrInfo 属性信息
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);
}
