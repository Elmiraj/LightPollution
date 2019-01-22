package com.zj.lightpollution.service.impl;

import com.zj.lightpollution.converter.ProductEntityToVo;
import com.zj.lightpollution.model.ProductEntity;
import com.zj.lightpollution.repository.ProductRepository;
import com.zj.lightpollution.service.ProductService;
import com.zj.lightpollution.vo.product.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductServiceImpl class
 * @author junzhang
 * @date 2019-01-15
 */

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 查询产品Vo
     * @return List<ProductVo>
     */
    @Override
    public List<ProductVo> findProductVoList() {
        List<ProductVo> productVoList = new ArrayList<>();
        try {
            List<ProductEntity> productEntityList = productRepository.findAllByOrderByProductName();
            for (ProductEntity productEntity : productEntityList){
                ProductVo productVo = new ProductEntityToVo().apply(productEntity);
                productVoList.add(productVo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productVoList;
    }
}
