package com.zj.lightpollution.converter;

import com.google.common.base.Function;
import com.zj.lightpollution.model.QuantityEntity;
import com.zj.lightpollution.utils.MyBeanUtils;
import com.zj.lightpollution.vo.quantity.QuantityVo;

/**
 * QuantityVoToEntity class
 * @author junzhang
 * @date 2019-01-18
 */

public class QuantityVoToEntity implements Function<QuantityVo, QuantityEntity> {
    @Override
    public QuantityEntity apply(QuantityVo quantityVo){
        QuantityEntity quantityEntity = new QuantityEntity();
        try {
            MyBeanUtils.copyBeanNotNull2Bean(quantityVo, quantityEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return quantityEntity;
    }
}
