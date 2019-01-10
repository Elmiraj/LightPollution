package com.zj.lightpollution.vo.customer;

import com.zj.lightpollution.vo.address.AddressVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * CustomerOperateVo class
 * @author junzhang
 * @date 2019-01-08
 */
@Getter
@Setter
public class CustomerOperateVo {
    private CustomerVo customerVo;

    private List<AddressVo> addressVoList;

    private String error;
}
