package com.zj.lightpollution.vo.customer;

import com.zj.lightpollution.vo.product.ProductVo;
import com.zj.lightpollution.vo.quantity.QuantityVo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * 客户VO
 * CustomerVo class
 * @author junzhang
 * @date 2019-01-05
 */

@Getter
@Setter
public class CustomerVo {
    /**
     * 客户id
     */
    private Long id;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 是否付款
     */
    private Integer isPaid;

    /**
     * 应付金额
     */
    private BigDecimal totalTotalPrice;

    /**
     * 已付金额
     */
    private BigDecimal paidMoney;

    /**
     * 地址id
     */
    private Long addressId;

    /**
     * 订货总数
     */
    private BigDecimal totalQuantity;

    /**
     * 订货种类
     */
    private Integer productCount;

    /**
     * 货物和数量的集合
     */
    private List<QuantityVo> quantityVoList;

    /**
     * 货物集合
     */
    private List<ProductVo> productVoList;
}
