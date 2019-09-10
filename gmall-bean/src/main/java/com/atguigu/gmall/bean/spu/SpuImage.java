package com.atguigu.gmall.bean.spu;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author goolearn
 * @date 2019/9/9 8:51
 */
@Data
public class SpuImage implements Serializable {
    @Column
    @Id
    private String id;
    @Column
    private String spuId;
    @Column
    private String imgName;
    @Column
    private String imgUrl;
}
