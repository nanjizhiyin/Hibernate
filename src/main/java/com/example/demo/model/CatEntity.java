package com.example.demo.model;

/**
 * @author gaojindan
 * @date 2018/10/31 14:17
 * @des
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 创建了一个实体类。
 *
 * 如何持久化呢？
 *
 * 1、使用@Entity进行实体类的持久化操作，当JPA检测到我们的实体类当中有
 *
 * @Entity 注解的时候，会在数据库中生成对应的表结构信息。
 *
 *
 * 如何指定主键以及主键的生成策略？
 *
 * 2、使用@Id指定主键.
 *
 *
 *
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2016年12月17日
 */
@Entity
@Table(name="Cat")
public class CatEntity implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true,
            nullable=false,
            columnDefinition = "int(11) COMMENT '类型'")
    private Long catId;

    @Column(columnDefinition="varchar(100) DEFAULT NULL COMMENT '名称'")
    private String catName;//姓名. cat_name

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

}
