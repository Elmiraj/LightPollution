package com.zj.lightpollution.service;

import com.zj.lightpollution.vo.product.ProductVo;

import java.util.List;

public interface ProductService {
    /**
     * 查询产品Vo
     * @return List<ProductVo>
     */
    List<ProductVo> findProductVoList();
}
