package com.zj.lightpollution.repository;

import com.zj.lightpollution.model.QuantityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * QuantityRepository class
 * @author junzhang
 * @date 2019-01-15
 */
public interface QuantityRepository extends JpaRepository<QuantityEntity,Long>, JpaSpecificationExecutor<QuantityEntity>{
    /**
     * 根据客户id查询
     * @param id Long
     * @return List<QuantityEntity>
     */
    List<QuantityEntity> findAllByCustomerEntityId(Long id);
}
