package com.zj.lightpollution.service;

import com.zj.lightpollution.model.CustomerEntity;
import com.zj.lightpollution.vo.customer.CustomerProductVo;
import com.zj.lightpollution.vo.customer.CustomerVo;
import org.springframework.data.domain.Pageable;

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
     * 保存客户
     * @param customerProductVo CustomerProductVo
     */
    void saveCustomer(CustomerProductVo customerProductVo);
    /**
     * 删除
     * @param id Long
     */
    void remove(Long id);

    /**
     * 查询客户VO列表
     * @param pageable Pageable
     * @return List<CustomerVo>
     */
    List<CustomerVo> findCustomerVoList(Pageable pageable);

    /**
     * 更具id查询客户
     * @param id Long
     * @return CustomerVo
     */
    CustomerVo findCustomerVoById(Long id);

    /**
     * 根据客户名称查询客户
     * @param customerName String
     * @return CustomerVo
     */
    CustomerVo findCustomerVoByCustomerName(String customerName);
}
