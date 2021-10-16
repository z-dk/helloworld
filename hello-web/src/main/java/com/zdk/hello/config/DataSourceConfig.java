package com.zdk.hello.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import com.zdk.hello.config.datasource.DynamicDataSource;
import com.zdk.hello.properties.DataBase1Properties;
import com.zdk.hello.properties.DataBase2Properties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>类 名 称</b> :  DataSourceConfig<br/>
 * <b>类 描 述</b> :  数据源配置<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/18 11:14<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/18 11:14<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Configuration
public class DataSourceConfig {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);
    
    @Resource
    private DataBase1Properties dataBase1Properties;
    
    @Resource
    private DataBase2Properties dataBase2Properties;
    
    @Resource
    private DataSource shardingDataSource;
    
    @Bean
    public DataSource helloWorldDataSource() {
        return getDataSource(dataBase1Properties.getUrl(), dataBase1Properties.getUsername(), 
                dataBase1Properties.getPassword(), dataBase1Properties.getDriverClassName());
    }
    
    @Bean
    public DataSource zdkDataDataSource() {
        return getDataSource(dataBase2Properties.getUrl(), dataBase2Properties.getUsername(), 
                dataBase2Properties.getPassword(), dataBase2Properties.getDriverClassName());
    }
    
    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSource = new HashMap<>(16);
        targetDataSource.put("hello-world", helloWorldDataSource());
        targetDataSource.put("hello-world-sharding", shardingDataSource);
        targetDataSource.put("zdk-data", zdkDataDataSource());
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(helloWorldDataSource());
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource作为数据源则不能实现切换
        sqlSessionFactory.setDataSource(dynamicDataSource());
        // 扫描Model
        sqlSessionFactory.setTypeAliasesPackage("com.zdk.**.entity");
        return sqlSessionFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
        return new DataSourceTransactionManager(dynamicDataSource());
    }
    
    private DataSource getDataSource(String url, String username, String password, String driverClassName) {
        LOGGER.info("数据源[{}]初始化", url);
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
    
}
