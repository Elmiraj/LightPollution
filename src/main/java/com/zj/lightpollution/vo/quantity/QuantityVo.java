package com.zj.lightpollution.vo.quantity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * QuantityVo class
 * @author junzhang
 * @date 2019-01-10
 */
@Getter
@Setter
public class QuantityVo {
    /**
     * id
     */
    private Long id;
    /**
     * 客户ID
     */
    private Long customerId;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 货物ID
     */
    private Long productId;
    /**
     * 货物名称
     */
    private String productName;
    /**
     * 旧数量
     */
    private BigDecimal oldQuantity;
    /**
     * 数量
     */
    private BigDecimal quantity;
    /**
     * 货物单价
     */
    private BigDecimal price;

    /**
     * 货物总价
     */
    private BigDecimal totalPrice;

    /**
     * 所有货物的总价
     */
    private BigDecimal totalTotalPrice;

}
