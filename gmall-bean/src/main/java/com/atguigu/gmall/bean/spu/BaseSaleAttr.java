package com.atguigu.gmall.bean.spu;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author goolearn
 * @date 2019/9/8 20:50
 */
@Data
public class BaseSaleAttr implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String name;
}
