package com.zj.lightpollution.converter;

import com.google.common.base.Function;
import com.zj.lightpollution.model.AddressEntity;
import com.zj.lightpollution.utils.MyBeanUtils;
import com.zj.lightpollution.vo.address.AddressVo;

/**
 * AddressEntityToVo class
 * @author junzhang
 * @date 2019-01-08
 */
public class AddressEntityToVo implements Function<AddressEntity, AddressVo> {
    @Override
    public AddressVo apply(AddressEntity addressEntity){
        AddressVo addressVo = new AddressVo();
        try {
            MyBeanUtils.copyBeanNotNull2Bean(addressEntity,addressVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return addressVo;
    }
}
