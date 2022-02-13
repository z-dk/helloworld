package com.zdk.hello.service.customer.mapper;

import com.zdk.hello.service.customer.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 客户信息表 Mapper 接口
 * </p>
 *
 * @author zdk
 * @since 2022-02-13
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    /**
     * 新增客户信息
     * @param customer 客户信息
     * @return 影响条数
     */
    Integer insertCustomer(Customer customer);

    /**
     * 根据主键id查询客户信息
     * @param id 主键id
     * @return 客户信息
     */
    Customer getCustomerById(Integer id);
    
}
