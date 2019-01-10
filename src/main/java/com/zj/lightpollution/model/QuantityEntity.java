package com.zj.lightpollution.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * QuantityEntity class
 * @author junzhang
 * @date 2019-01-05
 */
@Entity
@Getter
@Setter
@Table(name = "QUANTITY", indexes = {@Index(columnList = "ID", unique = true)})
public class QuantityEntity extends BaseEntity{
    /**
     * 客户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customerEntity;

    /**
     * 货物
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;

    /**
     * 数量
     */
    @Column(name = "QUANTITY")
    private BigDecimal quantity;

    /**
     * 库存
     */
    @Column(name = "STOCK")
    private BigDecimal stock;
}
