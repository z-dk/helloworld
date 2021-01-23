package com.zhudengkui.helloworld.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  MyFactoryBean<br/>
 * <b>类 描 述</b> :  自定义的factory bean<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/23 21:22<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/23 21:22<br/>
 * <b>修改备注</b> :  <br/>
 * @author zdk
 */
@Component
public class MyFactoryBean implements FactoryBean {
    
    @Override
    public Object getObject() throws Exception {
        String data1 = buildData1();
        String data2 = buildData2();
        return buildData3(data1, data2);
    }
    
    @Override
    public Class<?> getObjectType() {
        return null;
    }
    
    public String buildData1() {
        return "data1";
    }
    
    public String buildData2() {
        return "data2";
    }
    
    public String buildData3(String data1, String data2) {
        return data1 + data2;
    }
    
}
