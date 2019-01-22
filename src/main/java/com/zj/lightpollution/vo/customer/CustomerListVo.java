package com.zj.lightpollution.vo.customer;

import java.util.List;

/**
 * CustomerListVo class
 * @author junzhang
 * @date 2019-01-05
 */
public class CustomerListVo {
    /**
     * 客户信息列表VO
     */
    private CustomerListVo(){
        super();
    }

    public List<CustomerVo> customerVoList;

    public CustomerListVo(List<CustomerVo> customerVoList){
        this();
        this.customerVoList = customerVoList;
    }
}
