package com.zdk.hello.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  DataBase1Properties<br/>
 * <b>类 描 述</b> :  hello-world数据库连接配置<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/18 11:04<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/18 11:04<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.datasource1")
public class DataBase1Properties {
    
    private String url;
    
    private String username;
    
    private String password;
    
    private String driverClassName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
