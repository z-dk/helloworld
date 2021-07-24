package com.zdk.hello.config.datasource;

/**
 * <b>类 名 称</b> :  DataSourceHolder<br/>
 * <b>类 描 述</b> :  封装数据源操作<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/18 11:35<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/18 11:35<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class DataSourceHolder {
    
    private static final ThreadLocal<String> DATA_SOURCES = new ThreadLocal<>();
    
    public static void setDataSources(String customerType) {
        DATA_SOURCES.set(customerType);
    }
    
    public static String getDataSource() {
        return DATA_SOURCES.get();
    }
    
    public static void clearDataSource() {
        DATA_SOURCES.remove();
    }
    
}
