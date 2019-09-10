package com.atguigu.gmall.manage.mapper;

import com.atguigu.gmall.bean.BaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/7 8:46
 */
public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {
    /**
     * 返回平台属性信息及属性值信息
     * @param catalog3Id 三级类别ID
     * @return 平台属性
     */
    List<BaseAttrInfo> getAttrInfoListByCatalog3Id(String catalog3Id);
}
