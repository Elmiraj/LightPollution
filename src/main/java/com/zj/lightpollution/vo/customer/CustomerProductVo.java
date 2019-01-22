package com.zj.lightpollution.vo.customer;

import com.zj.lightpollution.vo.quantity.QuantityVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * CustomerProductVo class
 * @author junzhang
 * @date 2019-01-15
 */
@Getter
@Setter
public class CustomerProductVo {
    /**
     * 数量Vo集合
     */
    List<QuantityVo> quantityVoList;
    /**
     * 客户Vo
     */
    private CustomerVo customerVo;
}
