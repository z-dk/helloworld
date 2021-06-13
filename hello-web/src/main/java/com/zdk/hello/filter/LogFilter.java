package com.zdk.hello.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * <b>类 名 称</b> :  LogFilter<br/>
 * <b>类 描 述</b> :  日志启用开关过滤器<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 11:21<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 11:21<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class LogFilter implements Filter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("记录请求地址：{}", servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest,servletResponse);
        LOGGER.info("记录响应编码：{}", servletResponse.getCharacterEncoding());
    }
    
    @Override
    public void destroy() {
        
    }
}
