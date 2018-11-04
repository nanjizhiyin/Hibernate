package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author gaojindan
 * @date 2018/10/31 17:08
 * @des
 */

@Entity
public class CatInfo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true,
            nullable=false,
            columnDefinition = "int(11) COMMENT '类型'")
    private Long catInfoId;

    @Column(columnDefinition="varchar(100) DEFAULT NULL COMMENT '价格'")
    private String price;//


    public Long getCatInfoId() {
        return catInfoId;
    }

    public void setCatInfoId(Long catInfoId) {
        this.catInfoId = catInfoId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
