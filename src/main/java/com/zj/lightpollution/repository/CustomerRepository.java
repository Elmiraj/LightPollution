package com.zj.lightpollution.repository;

import com.zj.lightpollution.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CustomerRepository class
 * @author junzhang
 * @date 2019-01-05
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, JpaSpecificationExecutor<CustomerEntity>{
    /**
     * 根据id查询客户
     * @param id Long
     * @return CustomerEntity
     */
    CustomerEntity findCustomerEntityById(Long id);

    /**
     * 根据客户名称查询客户
     * @param customerName String
     * @return CustomerEntity
     */
    CustomerEntity findCustomerEntityByCustomerName(String customerName);

    /**
     * 根据姓名排序
     * @return List<CustomerEntity>
     */
    List<CustomerEntity> findAllByOrderByCustomerName();
}
