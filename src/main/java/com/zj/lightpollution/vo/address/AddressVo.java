package com.zj.lightpollution.vo.address;

import lombok.Getter;
import lombok.Setter;

/**
 * AddressVo class
 * @author junzhang
 * @date 2019-01-08
 */
@Getter
@Setter
public class AddressVo {
    /**
     * 地址id
     */
    private Long id;

    /**
     * 地址名称
     */
    private String addressName;

    public AddressVo(){}
}
