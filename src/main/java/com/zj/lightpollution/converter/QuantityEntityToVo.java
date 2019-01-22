package com.zj.lightpollution.converter;

import com.google.common.base.Function;
import com.zj.lightpollution.model.QuantityEntity;
import com.zj.lightpollution.utils.MyBeanUtils;
import com.zj.lightpollution.vo.quantity.QuantityVo;

/**
 * QuantityEntityToVo class
 * @author junzhang
 * @date 2019-01-15
 */

public class QuantityEntityToVo implements Function<QuantityEntity, QuantityVo>{
    @Override
    public QuantityVo apply(QuantityEntity quantityEntity){
        QuantityVo quantityVo = new QuantityVo();
        try {
            MyBeanUtils.copyBeanNotNull2Bean(quantityEntity,quantityVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return quantityVo;
    }
}
