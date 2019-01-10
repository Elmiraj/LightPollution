package com.zj.lightpollution.service.impl;

import com.zj.lightpollution.converter.AddressEntityToVo;
import com.zj.lightpollution.model.AddressEntity;
import com.zj.lightpollution.repository.AddressRepository;
import com.zj.lightpollution.service.AddressService;
import com.zj.lightpollution.vo.address.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * AddressServiceImpl class
 * @author junzhang
 * @date 2019-01-08
 */

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressVo> findAddressVoList() {
        List<AddressVo> addressVoList = new ArrayList<>();
        try {
            List<AddressEntity> addressEntityList = addressRepository.findAll();
            for (AddressEntity addressEntity : addressEntityList){
                AddressVo addressVo = new AddressEntityToVo().apply(addressEntity);
                addressVoList.add(addressVo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return addressVoList;
    }
}
