package com.atguigu.gmall.bean.sku;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author goolearn
 * @date 2019/9/9 17:06
 */
@Data
public class SkuAttrValue implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String attrId;

    @Column
    private String valueId;

    @Column
    private String skuId;

}
