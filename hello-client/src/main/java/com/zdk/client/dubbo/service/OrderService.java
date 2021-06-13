package com.zdk.client.dubbo.service;

import java.util.List;

/**
 * <b>类 名 称</b> :  OrderService<br/>
 * <b>类 描 述</b> :  订单接口<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/6/13 16:08<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/6/13 16:08<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public interface OrderService {
    
    List<String> listOrder(String userId);
    
}
