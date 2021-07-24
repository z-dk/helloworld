package com.zdk.hello.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <b>类 名 称</b> :  DynamicDataSource<br/>
 * <b>类 描 述</b> :  动态数据源<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/18 11:38<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/18 11:38<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }
}
