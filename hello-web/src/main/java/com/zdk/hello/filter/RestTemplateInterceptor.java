package com.zdk.hello.filter;

import com.zdk.hello.util.MdcUtil;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * <b>类 名 称</b> :  RestTemplateInterceptor<br/>
 * <b>类 描 述</b> :  restTemplate的拦截器<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/24 15:40<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/24 15:40<br/>
 * <b>修改备注</b> :  暂时没有实现traceId的生成规则<br/>
 *
 * @author zdk
 */
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        httpRequest.getHeaders().set("traceId", MdcUtil.get());
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
