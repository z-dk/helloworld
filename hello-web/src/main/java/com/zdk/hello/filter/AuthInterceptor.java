package com.zdk.hello.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>类 名 称</b> :  AuthInterceptor<br/>
 * <b>类 描 述</b> :  自定义权限过滤器<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 11:04<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 11:04<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String remoteHost = request.getRemoteHost();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("请求权限认证：{}", remoteHost);
        }
        return super.preHandle(request, response, handler);
    }
}
