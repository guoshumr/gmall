package com.atguigu.gmall.manage.mapper;

import com.atguigu.gmall.bean.spu.SpuSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/9 8:57
 */
public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {
    /**
     * @param spuId spuid
     * @return SpuSaleAttr集合
     */
    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

}
