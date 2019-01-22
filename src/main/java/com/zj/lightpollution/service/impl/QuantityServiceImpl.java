package com.zj.lightpollution.service.impl;

import com.zj.lightpollution.converter.QuantityEntityToVo;
import com.zj.lightpollution.converter.QuantityVoToEntity;
import com.zj.lightpollution.model.QuantityEntity;
import com.zj.lightpollution.repository.QuantityRepository;
import com.zj.lightpollution.service.QuantityService;
import com.zj.lightpollution.vo.quantity.QuantityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * QuantityServiceImpl class
 * @author junzhang
 * @date 2019-01-15
 */

@Service
public class QuantityServiceImpl implements QuantityService {
    private final QuantityRepository quantityRepository;

    @Autowired
    public QuantityServiceImpl(QuantityRepository quantityRepository){
        this.quantityRepository = quantityRepository;
    }


    /**
     * 查询数量Vo
     * @param id Long
     * @return List<QuantityVo>
     */
    @Override
    public List<QuantityVo> findQuantityVoList(Long id) {
        List<QuantityVo> quantityVoList = new ArrayList<>();
        try {
            List<QuantityEntity> quantityEntityList = quantityRepository.findAllByCustomerEntityId(id);
            for (QuantityEntity quantityEntity : quantityEntityList){
                QuantityVo quantityVo = new QuantityEntityToVo().apply(quantityEntity);
                quantityVoList.add(quantityVo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return quantityVoList;
    }

    /**
     * 保存Quantity
     * @param quantityVo QuantityVo
     */
    @Override
    public void save(QuantityVo quantityVo){
        try {
            QuantityEntity quantityEntity = new QuantityVoToEntity().apply(quantityVo);
            if (quantityEntity != null){
                quantityRepository.saveAndFlush(quantityEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
