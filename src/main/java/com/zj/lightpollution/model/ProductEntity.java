package com.zj.lightpollution.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 货物PO
 * ProductEntity class
 * @author junzhang
 * @date 2019-01-05
 */
@Entity
@Getter
@Setter
@Table(name = "PRODUCT",indexes = {@Index(columnList = "ID", unique = true)})
public class ProductEntity extends BaseEntity{
    /**
     * 货物名
     */
    @Column(name = "PRODUCT_NAME")
    private String productName;

    /**
     * 单价
     */
    @Column(name = "PRICE")
    private BigDecimal price;

    /**
     * 库存
     */
    @Column(name = "STOCK")
    private BigDecimal stock;
}
