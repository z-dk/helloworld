package com.zdk.provider.dubbo.service.impl;

import com.zdk.client.dubbo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>类 名 称</b> :  OrderServiceImpl<br/>
 * <b>类 描 述</b> :  服务提供者<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/6/13 16:16<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/6/13 16:16<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Service
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = OrderService.class)
public class OrderServiceImpl implements OrderService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public List<String> listOrder(String userId) {
        LOGGER.info("userId:{}", userId);
        return new ArrayList<>(Arrays.asList("provider", "orderImpl"));
    }
}
