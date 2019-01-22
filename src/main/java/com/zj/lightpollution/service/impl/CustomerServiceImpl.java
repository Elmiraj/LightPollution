package com.zj.lightpollution.service.impl;

import com.zj.lightpollution.converter.CustomerEntityToVo;
import com.zj.lightpollution.converter.CustomerVoToEntity;
import com.zj.lightpollution.model.CustomerEntity;
import com.zj.lightpollution.repository.CustomerRepository;
import com.zj.lightpollution.service.CustomerService;
import com.zj.lightpollution.vo.customer.CustomerProductVo;
import com.zj.lightpollution.vo.customer.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * CustomerServiceImpl class
 * @author junzhang
 * @date 2019-01-05
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * 保存
     * @param customerEntity CustomerEntity
     * @return CustomerEntity
     */
    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        return null;
    }

    /**
     * 删除
     * @param id Long
     */
    @Override
    public void remove(Long id) {

    }

    /**
     * 查询客户VO列表
     * @return List<CustomerVo>
     */
    @Override
    public List<CustomerVo> findCustomerVoList(Pageable pageable) {
        List<CustomerVo> customerVoList = new ArrayList<>();
        try {
            List<CustomerEntity> customerList = customerRepository.findAllByOrderByCustomerName();
            for (CustomerEntity customer : customerList){
                CustomerVo customerVo = new CustomerEntityToVo().apply(customer);
                customerVoList.add(customerVo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customerVoList;
    }

    @Override
    public CustomerVo findCustomerVoById(Long id){
        CustomerEntity customerEntity = customerRepository.findCustomerEntityById(id);
        if (customerEntity != null){
            return new CustomerEntityToVo().apply(customerEntity);
        }else {
            return null;
        }
    }

    /**
     * 根据客户名称查询客户
     *
     * @param customerName String
     * @return CustomerVo
     */
    @Override
    public CustomerVo findCustomerVoByCustomerName(String customerName) {
        CustomerEntity customerEntity = customerRepository.findCustomerEntityByCustomerName(customerName);
        if (customerEntity != null){
            return new CustomerEntityToVo().apply(customerEntity);
        }else {
            return null;
        }
    }

    @Override
    public void save(CustomerVo customerVo){
        try {
            CustomerEntity customerEntity = new CustomerVoToEntity().apply(customerVo);
            if (customerEntity != null) {
                customerRepository.saveAndFlush(customerEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 保存客户
     * @param customerProductVo CustomerProductVo
     */
    @Override
    public void saveCustomer(CustomerProductVo customerProductVo) {

    }
}
