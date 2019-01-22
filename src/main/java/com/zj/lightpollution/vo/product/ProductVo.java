package com.zj.lightpollution.vo.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * ProductVo class
 * @author junzhang
 * @date 2019-01-15
 */

@Getter
@Setter
public class ProductVo {
    /**
     * id
     */
    private Long id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 选择人数
     */
    private Integer chooseNumber;

    /**
     * 订货数
     */
    private BigDecimal chooseQuantity;

    /**
     * 货物总数
     */
    private BigDecimal totalQuantity;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 库存
     */
    private BigDecimal stock;
}
