package com.zdk.hello.config.database;

import com.zdk.hello.aop.advisor.DataSourceAdvisor;
import org.springframework.aop.Advisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <b>类 名 称</b> :  DataBaseConfig<br/>
 * <b>类 描 述</b> :  hello-world数据库配置<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/18 11:25<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/18 11:25<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Configuration
@EnableTransactionManagement
public class DataBaseConfig {
    
    @Bean
    public Advisor advisor() {
        return new DataSourceAdvisor();
    }
    
}
