package com.atguigu.gmall.bean.sku;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/9 16:48
 */
@Data
public class SkuInfo implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private String id;

    @Column
    private String spuId;

    @Column
    private BigDecimal price;

    @Column
    private String skuName;

    @Column
    private BigDecimal weight;

    @Column
    private String skuDesc;

    @Column
    private String catalog3Id;

    @Column
    private String skuDefaultImg;

    @Transient
    private List<SkuAttrValue> skuAttrValueList;

    @Transient
    private List<SkuSaleAttrValue> skuSaleAttrValueList;

    @Transient
    private List<SkuImage> skuImageList;
}
