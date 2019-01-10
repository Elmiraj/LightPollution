package com.zj.lightpollution.converter;

import com.google.common.base.Function;
import com.zj.lightpollution.model.CustomerEntity;
import com.zj.lightpollution.utils.MyBeanUtils;
import com.zj.lightpollution.vo.customer.CustomerVo;

/**
 * CustomerVoToEntity class
 * @author junzhang
 * @date 2019-01-10
 */

public class CustomerVoToEntity implements Function<CustomerVo, CustomerEntity> {
    @Override
    public CustomerEntity apply(CustomerVo customerVo){
        CustomerEntity customerEntity = new CustomerEntity();
        try {
            MyBeanUtils.copyBeanNotNull2Bean(customerVo,customerEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return customerEntity;
    }
}
