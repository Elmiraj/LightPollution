package com.zj.lightpollution.repository;

import com.zj.lightpollution.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * ProductRepository class
 * @author junzhang
 * @date 2019-01-15
 */

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
    /**
     * 根据产品名称排序查找所有产品
     * @return List<ProductEntity>
     */
    List<ProductEntity> findAllByOrderByProductName();
}
