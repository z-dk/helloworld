package com.zdk.hello.aop.advice;

import com.zdk.hello.annotations.TargetDataSource;
import com.zdk.hello.config.datasource.DataSourceHolder;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * <b>类 名 称</b> :  DataSourceExchange<br/>
 * <b>类 描 述</b> :  切换数据源-通知<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/18 11:47<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/18 11:47<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class DataSourceExchange implements MethodBeforeAdvice, AfterReturningAdvice {
    
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) {
        DataSourceHolder.clearDataSource();
    }

    @Override
    public void before(Method method, Object[] objects, Object target) {
        TargetDataSource targetDataSource;
        if (method.isAnnotationPresent(TargetDataSource.class)) {
            targetDataSource = method.getAnnotation(TargetDataSource.class);
            DataSourceHolder.setDataSources(targetDataSource.name());
        } else if (target.getClass().isAnnotationPresent(TargetDataSource.class)) {
            targetDataSource = target.getClass().getAnnotation(TargetDataSource.class);
            DataSourceHolder.setDataSources(targetDataSource.name());
        }
    }
}
