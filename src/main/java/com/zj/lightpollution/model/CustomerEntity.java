package com.zj.lightpollution.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 客户PO
 * CustomerEntity class
 * @author junzhang
 * @date 2019-01-05
 */
@Getter
@Setter
@Entity
@Table(name = "CUSTOMER", indexes = {@Index(columnList = "ID",unique = true)})
public class CustomerEntity extends BaseEntity implements Serializable {
    /**
     * 客户姓名
     */
    @Column(name = "CUSTOMER_NAME", length = 20, nullable = false)
    private String customerName;

    /**
     * 是否付款
     */
    @Column(name = "IS_PAID", nullable = false)
    private Integer isPaid;

    /**
     * 应付金额
     */
    @Column(name = "TOTAl_TOTAL_PRICE", length = 50)
    private BigDecimal totalTotalPrice;

    /**
     * 已付金额
     */
    @Column(name = "PAID_MONEY", length = 50)
    private BigDecimal paidMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity addressEntity;
}
