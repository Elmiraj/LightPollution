package com.zj.lightpollution.service;

import com.zj.lightpollution.vo.address.AddressVo;

import java.util.List;

public interface AddressService {
    List<AddressVo> findAddressVoList();
}
