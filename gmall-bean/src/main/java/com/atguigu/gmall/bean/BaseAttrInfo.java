package com.atguigu.gmall.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author goolearn
 * @date 2019/9/7 8:32
 */
@Data
public class BaseAttrInfo implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;

    @Transient
    @JsonProperty(value = "attrValueList")
    private List<BaseAttrValue> attrValues;

}
