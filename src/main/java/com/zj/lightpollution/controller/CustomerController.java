package com.zj.lightpollution.controller;

import com.zj.lightpollution.service.AddressService;
import com.zj.lightpollution.service.CustomerService;
import com.zj.lightpollution.vo.address.AddressVo;
import com.zj.lightpollution.vo.customer.CustomerOperateVo;
import com.zj.lightpollution.vo.customer.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CustomerController class
 * @author junzhang
 * @date 2019-01-05
 */
@Controller
public class CustomerController {

    private final CustomerService customerService;

    private final AddressService addressService;

    @Autowired
    public CustomerController(CustomerService customerService, AddressService addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }

    @GetMapping("/")
    public String customerList(Model model,
                               @RequestParam(value="page", defaultValue="0") int page,
                               @RequestParam(value="size", defaultValue="10") int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(page, size, sort);
        List<CustomerVo> customerVoList = customerService.findCustomerVoList();
        model.addAttribute("customerVoList",customerVoList);
        return "customer";
    }

    /**
     * 添加学生信息页面
     */
    @GetMapping("newCustomer")
    public String newCustomer(Model model) {
        CustomerOperateVo customerOperateVo = new CustomerOperateVo();
        List<AddressVo> addressVoList = addressService.findAddressVoList();
        customerOperateVo.setAddressVoList(addressVoList);
        model.addAttribute("customerOperateVo",customerOperateVo);
        return "customer/newCustomer";
    }

    /**
     * 执行添加学生操作
     */
    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute(value="customerVo") CustomerVo customerVo, Model model) {
        CustomerVo existCustomer = customerService.findCustomerVoById(customerVo.getId());
        if (existCustomer == null){
            customerService.save(customerVo);
            return "redirect:/";
        }else{
            CustomerOperateVo customerOperateVo = new CustomerOperateVo();
            customerOperateVo.setCustomerVo(customerVo);
            List<AddressVo> addressVoList = addressService.findAddressVoList();
            customerOperateVo.setAddressVoList(addressVoList);
            customerOperateVo.setError("客户信息已经存在");
            model.addAttribute("customerOperateVo", customerOperateVo);
            return "customer/newCustomer";
        }
    }
}
