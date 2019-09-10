package com.atguigu.gmall.bean.sku;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author goolearn
 * @date 2019/9/9 18:09
 */
@Data
public class SkuImage implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String skuId;
    @Column
    private String imgName;
    @Column
    private String imgUrl;
    @Column
    private String spuImgId;
    @Column
    private String isDefault;
}
