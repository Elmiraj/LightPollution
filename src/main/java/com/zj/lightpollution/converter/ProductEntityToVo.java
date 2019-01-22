package com.zj.lightpollution.converter;

import com.google.common.base.Function;
import com.zj.lightpollution.model.ProductEntity;
import com.zj.lightpollution.utils.MyBeanUtils;
import com.zj.lightpollution.vo.product.ProductVo;

/**
 * ProductEntityToVo class
 * @author junzhang
 * @date 2019-01-15
 */

public class ProductEntityToVo implements Function<ProductEntity, ProductVo> {
    @Override
    public ProductVo apply(ProductEntity productEntity){
        ProductVo productVo = new ProductVo();
        try {
            MyBeanUtils.copyBeanNotNull2Bean(productEntity,productVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return productVo;
    }
}
