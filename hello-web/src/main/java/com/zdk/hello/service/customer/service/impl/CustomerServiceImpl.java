package com.zdk.hello.service.customer.service.impl;

import com.zdk.hello.service.customer.entity.Customer;
import com.zdk.hello.service.customer.mapper.CustomerMapper;
import com.zdk.hello.service.customer.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户信息表 服务实现类
 * </p>
 *
 * @author zdk
 * @since 2022-02-13
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
