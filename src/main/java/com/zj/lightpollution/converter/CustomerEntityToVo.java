package com.zj.lightpollution.converter;

import com.google.common.base.Function;
import com.zj.lightpollution.model.CustomerEntity;
import com.zj.lightpollution.utils.MyBeanUtils;
import com.zj.lightpollution.vo.customer.CustomerVo;

/**
 * CustomerEntityToVo class
 * @author junzhang
 * @date 2019-01-05
 */
public class CustomerEntityToVo implements Function<CustomerEntity, CustomerVo> {
    @Override
    public CustomerVo apply(CustomerEntity customerEntity){
        CustomerVo customerVo = new CustomerVo();
        try {
            MyBeanUtils.copyBeanNotNull2Bean(customerEntity,customerVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return customerVo;
    }
}
