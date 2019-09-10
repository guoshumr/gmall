package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author goolearn
 * @date 2019/9/7 8:29
 */
@Data
public class BaseCatalog3 implements Serializable {

    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String catalog2Id;

}
