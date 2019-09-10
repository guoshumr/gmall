package com.atguigu.gmall.bean.sku;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author goolearn
 * @date 2019/9/9 17:07
 */
@Data
public class SkuSaleAttrValue implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String skuId;

    @Column
    private String saleAttrId;

    @Column
    private  String saleAttrValueId;

    @Column
    private String saleAttrName;

    @Column
    private String saleAttrValueName;

}
