package com.zdk.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdk.client.dubbo.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>类 名 称</b> :  ConsumerController<br/>
 * <b>类 描 述</b> :  消费者controller<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/6/13 20:08<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/6/13 20:08<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@RestController
@RequestMapping("consumerController")
public class ConsumerController {
    
    @Reference
    OrderService orderService;
    
    @RequestMapping("getOrder")
    public String getOrderByUserId(String userId) {
        String resultStr = orderService.listOrder(userId).toString();
        System.out.println(resultStr);
        return resultStr;
    }
    
}
