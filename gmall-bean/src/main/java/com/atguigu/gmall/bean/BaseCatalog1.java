package com.atguigu.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author goolearn
 * @date 2019/9/6 21:02
 */
@Data
public class BaseCatalog1 implements Serializable {

    @Id
    @Column
    private String id;

    @Column
    private String name;
}
