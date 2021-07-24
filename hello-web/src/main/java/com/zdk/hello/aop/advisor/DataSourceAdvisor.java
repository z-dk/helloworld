package com.zdk.hello.aop.advisor;

import com.zdk.hello.aop.advice.DataSourceExchange;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称</b> :  DataSourceAdvisor<br/>
 * <b>类 描 述</b> :  advisor<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/7/18 16:58<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/7/18 16:58<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
@Component
public class DataSourceAdvisor implements PointcutAdvisor {
    
    @Override
    public Pointcut getPointcut() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.zdk.hello.service..*.*(..))");
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return new DataSourceExchange();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
