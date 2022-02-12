package com.zdk.hello.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <b>类 名 称</b> :  MybatisPlusConfig<br/>
 * <b>类 描 述</b> :  mybatis-plus的配置类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/12/5 13:37<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/12/5 13:37<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {
    
    @Bean
    public PaginationInnerInterceptor paginationInterceptor() {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        paginationInterceptor.setDbType(DbType.MYSQL);
        paginationInterceptor.setMaxLimit(50L);
        return paginationInterceptor;
    }
    
}
