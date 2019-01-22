package com.zj.lightpollution.controller;

import com.zj.lightpollution.service.AddressService;
import com.zj.lightpollution.service.CustomerService;
import com.zj.lightpollution.service.ProductService;
import com.zj.lightpollution.service.QuantityService;
import com.zj.lightpollution.vo.address.AddressVo;
import com.zj.lightpollution.vo.customer.CustomerOperateVo;
import com.zj.lightpollution.vo.customer.CustomerProductVo;
import com.zj.lightpollution.vo.customer.CustomerVo;
import com.zj.lightpollution.vo.product.ProductVo;
import com.zj.lightpollution.vo.quantity.QuantityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    private final ProductService productService;

    private final QuantityService quantityService;
    @Autowired
    public CustomerController(CustomerService customerService, AddressService addressService,
                              ProductService productService, QuantityService quantityService) {
        this.customerService = customerService;
        this.addressService = addressService;
        this.productService = productService;
        this.quantityService = quantityService;
    }

    /**
     * 客户主界面
     * @param model Model
     * @param page int
     * @param size int
     * @return "customer/customer"
     */
    @GetMapping("/")
    public String customerList(Model model,
                               @RequestParam(value="page", defaultValue="0") int page,
                               @RequestParam(value="size", defaultValue="10") int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(page, size, sort);
        List<CustomerVo> customerVoList = customerService.findCustomerVoList(pageable);
        model.addAttribute("customerVoList",customerVoList);
        return "customer/customer";
    }

    /**
     * 添加客户信息页面
     * @param model Model
     * @return "customer/newCustomer"
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
     * 保存客户
     * @param customerVo CustomerVo
     * @param model Model
     * @return url
     */
    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute(value="customerVo") CustomerVo customerVo, Model model) {
        CustomerVo existCustomer = customerService.findCustomerVoByCustomerName(customerVo.getCustomerName());
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

    /**
     * 跳转订货页面
     * @param customerVo CustomerVo
     * @param model Model
     * @return "customer/chooseProduct"
     */
    @GetMapping("goChooseProduct")
    public String goChooseProduct(@ModelAttribute(value="customerVo") CustomerVo customerVo, Model model){
        List<ProductVo> productVoList = productService.findProductVoList();
        List<QuantityVo> quantityVoList = quantityService.findQuantityVoList(customerVo.getId());
        customerVo.setProductVoList(productVoList);
        customerVo.setQuantityVoList(quantityVoList);
        // model.addAttribute("productVoList", productVoList);
        // model.addAttribute("quantityVoList", quantityVoList);
        model.addAttribute("customerVo", customerVo);
        return "customer/chooseProduct";
    }

    @PostMapping("chooseProduct")
    public String chooseProduct(@ModelAttribute(value="customerVo") CustomerVo customerVo, ProductVo productVo){
        CustomerProductVo customerProductVo = new CustomerProductVo();
        Long id = customerVo.getId();
        // for (QuantityVo quantityVo : customerProductVo.getQuantityVoList()){
        //     for (ProductVo productVo : productVoList){
        //         if (productVo.getChooseQuantity() != null){
        //             if (!productVo.getChooseQuantity().equals(BigDecimal.ZERO)){
        //                 quantityVo.setProductId(productVo.getId());
        //                 quantityVo.setCustomerId(customerVo.getId());
        //                 quantityVo.setQuantity(productVo.getChooseQuantity());
        //                 quantityService.save(quantityVo);
        //             }
        //         }
        //     }
        // }
        return "redirect:/";
    }
}
