package com.zj.lightpollution.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AddressEntity class
 * @author junzhang
 * @date 2019-01-05
 */
@Entity
@Getter
@Setter
@Table(name = "ADDRESS", indexes = {@Index(columnList = "ID", unique = true)})
public class AddressEntity extends BaseEntity{
    /**
     * 地址名称
     */
    @Column(name = "ADDRESS_NAME")
    private String addressName;

    @OneToMany(mappedBy = "addressEntity", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<CustomerEntity> customerEntityList = new ArrayList<>();
}
