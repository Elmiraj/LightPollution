package com.zj.lightpollution.service;

import com.zj.lightpollution.vo.quantity.QuantityVo;

import java.util.List;

/**
 * QuantityService class
 * @author junzhang
 * @date 2019-01-15
 */

public interface QuantityService {
    /**
     * 查询数量Vo
     * @param id Long
     * @return List<QuantityVo>
     */
    List<QuantityVo> findQuantityVoList(Long id);

    /**
     * 保存Quantity
     * @param quantityVo QuantityVo
     */
    void save(QuantityVo quantityVo);
}
