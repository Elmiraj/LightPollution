package com.zj.lightpollution.service;

import com.zj.lightpollution.model.CustomerEntity;
import com.zj.lightpollution.vo.customer.CustomerVo;

import java.util.List;

/**
 * CustomerService class
 * @author junzhang
 * @date 2019-01-05
 */
public interface CustomerService {
    /**
     * 保存
     * @param customerEntity CustomerEntity
     * @return CustomerEntity
     */
    CustomerEntity save(CustomerEntity customerEntity);

    /**
     * 保存CustomerVo
     * @param customerVo CustomerVo
     */
    void save(CustomerVo customerVo);

    /**
     * 删除
     * @param id Long
     */
    void remove(Long id);

    /**
     * 查询客户VO列表
     * @return List<CustomerVo>
     */
    List<CustomerVo> findCustomerVoList();

    /**
     * 更具id查询客户
     * @param id Long
     * @return CustomerVo
     */
    CustomerVo findCustomerVoById(Long id);
}
